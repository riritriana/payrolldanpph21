package com.project.payrolldanpph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payrolldanpph21.models.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {
    
}
