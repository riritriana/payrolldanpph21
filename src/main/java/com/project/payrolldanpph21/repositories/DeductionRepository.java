package com.project.payrolldanpph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payrolldanpph21.models.Deduction;

public interface DeductionRepository extends JpaRepository<Deduction, Long>{
    
}
