package com.example.employeeproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeproject.Model.Employee;
import com.example.employeeproject.Service.EmployeeService;
import com.example.employeeproject.Service.EmployeeServiceImp;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    // This is the work of Service class
    // List<Employee> employees = new ArrayList<>();

    // If we dont want to use this
    // EmployeeService employeeService = new EmployeeServiceImp();
    // Dependency injection
    // @Autowired
    // EmployeeService employeeService;

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {

        // This is the work of Service class
        // Employee employee = new Employee();
        // employee.setName("Lodhi");
        // employees.add(employee);

        // list of employees
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // This is the work of Service class
        // employees.add(employee);
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Delete successfully";
        } else {
            return "Delete failed";
        }
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employeeEntity) {
        return employeeService.updateEmployee(employeeEntity, id);
    }
}
