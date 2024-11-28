package com.project.payrolldanpph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payrolldanpph21.models.Payroll;

public interface PayrollRepository extends JpaRepository <Payroll,Long>{
    
}
