package com.example.splitwisefeb24.repositories;

import com.example.splitwisefeb24.models.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(Long userId);
}
