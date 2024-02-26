package com.example.splitwisefeb24.strategy;

import com.example.splitwisefeb24.models.Expense;
import com.example.splitwisefeb24.models.ExpenseUser;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expensesToSettleUp);
}
