package com.example.splitwisefeb24.strategy;

import com.example.splitwisefeb24.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapsSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettleUp) {
        /*
        Go through all the expenses to settle up and find the people who
        have paid extra vs the people who have paid lesser and create the
        Min Heap and Max Heap corresponding to this.
         */
        return null;
    }
}
