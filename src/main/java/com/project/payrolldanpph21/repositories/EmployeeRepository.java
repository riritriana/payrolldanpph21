package com.project.payrolldanpph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payrolldanpph21.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
