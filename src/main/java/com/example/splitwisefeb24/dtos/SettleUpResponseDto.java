package com.example.splitwisefeb24.dtos;

import com.example.splitwisefeb24.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDto {
    private List<Expense> expenses;
}
