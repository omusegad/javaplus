package com.commerce.salesapp.repository;

import com.commerce.salesapp.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
