package com.project.payrolldanpph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payrolldanpph21.models.Employee;
import com.project.payrolldanpph21.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void save (Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void delete (Long id){
        employeeRepository.deleteById(id);
    }
    public Employee findById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    
}
