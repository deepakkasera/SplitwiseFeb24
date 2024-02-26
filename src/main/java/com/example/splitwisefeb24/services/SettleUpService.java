package com.example.splitwisefeb24.services;

import com.example.splitwisefeb24.exceptions.InvalidUserException;
import com.example.splitwisefeb24.models.Expense;
import com.example.splitwisefeb24.models.ExpenseUser;
import com.example.splitwisefeb24.models.User;
import com.example.splitwisefeb24.repositories.ExpenseUserRepository;
import com.example.splitwisefeb24.repositories.UserRepository;
import com.example.splitwisefeb24.strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    SettleUpService(UserRepository userRepository,
                    ExpenseUserRepository expenseUserRepository,
                    SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) throws InvalidUserException {
        //DSA problem.
        /*
        1. Get all the expenses for the user from DB.
        2. Go through all the expenses and find out all the people involved
        in the expenses, and how much they have paid extra/lesser.
        3. Use Min Heap and Max heap to find all the transactions that needs to be done to settle up.
        4. Return all the transactions to the User.
         */
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            //throw an Exception.
            throw new InvalidUserException("Invalid userId");
        }

        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(userId);

        Set<Expense> expenses = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expenses.add(expenseUser.getExpense());
        }

        List<Expense> settledUpExpenses = settleUpStrategy.settleUp(
                expenses.stream().toList()
        );

        List<Expense> finalSettleUpExpenses = new ArrayList<>();
        for(Expense settleUpExpense : settledUpExpenses) {
            for (ExpenseUser expenseUser : settleUpExpense.getExpenseUsers()) {
                if (expenseUser.getUser().equals(user)) {
                    finalSettleUpExpenses.add(settleUpExpense);
                }
            }
        }

        return finalSettleUpExpenses;
    }
}

/*
ExpenseUser -> E123U1, E123U2

User - A

A -> B : 100
A -> C : 200
D -> E : 300
 */
