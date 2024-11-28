package com.project.payrolldanpph21.controllers;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.project.payrolldanpph21.models.Employee;
import com.project.payrolldanpph21.services.EmployeeService;
import com.project.payrolldanpph21.services.PositionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;


    @GetMapping("/employee")
    public String employee(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();
        model.addAttribute("employee", employee);
        return "/employee/employee";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model) {
        // List<Employee> employees = new ArrayList<>();
        model.addAttribute("employee", new Employee());
        model.addAttribute("position", positionService.getAllPositions());
        return "/employee/add-employee";
    }

    
    @PostMapping("/save-employee")
    public String saveEmployee(Employee employee, Model model){
        employeeService.save(employee);
        return "redirect:/employee";
    }    

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id, Model model) {
        employeeService.delete(id);
        return "redirect:/employee";
    }
    
    @GetMapping("/update-employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Long id, Model model) {
    Employee employee = employeeService.findById(id);
    model.addAttribute("employee", employee);
    model.addAttribute("position", positionService.getAllPositions());
    return "/employee/update-employee";
    }
    
        @PostMapping("save-update-employee/{id}")
    public String saveUpdate(@PathVariable(value = "id") Long id, @ModelAttribute("employee") Employee employee, Model model){
        Employee update = employeeService.findById(id);
        if (update != null) {
            update.setName(employee.getName());
            update.setGender(employee.getGender());
            update.setStatus(employee.getStatus());
            update.setPosition(employee.getPosition());
            update.setAllowances(employee.getAllowances());
            update.setEntryDate(employee.getEntryDate());
            employeeService.save(update);
        }
        return "redirect:/employee";
    }

    
    
}
