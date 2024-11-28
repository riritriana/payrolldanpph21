package com.project.payrolldanpph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payrolldanpph21.models.Allowance;

public interface AllowanceRepository extends JpaRepository<Allowance,Long> {
    
}
