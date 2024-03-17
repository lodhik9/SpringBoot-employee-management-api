package com.example.employeeproject.Service;

import java.util.List;

import com.example.employeeproject.Model.Employee;

// Service is for business logic
public interface EmployeeService {
    String createEmployee(Employee employee);

    List<Employee> readEmployees();

    Employee readEmployee(Long id);

    boolean deleteEmployee(Long id);

    String updateEmployee(Employee employee, Long id);
}
