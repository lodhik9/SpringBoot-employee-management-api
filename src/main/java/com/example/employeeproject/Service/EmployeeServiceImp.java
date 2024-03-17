package com.example.employeeproject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.employeeproject.Entity.EmployeeEntity;
import com.example.employeeproject.Model.Employee;
import com.example.employeeproject.Repository.EmployeeRepository;

public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {

        // Convert model into Entity
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        // employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employeeModel = new Employee();

        BeanUtils.copyProperties(employeeEntity, employeeModel);

        return employeeModel;
    }

    @Override
    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEntity> employeesList = employeeRepository.findAll();

        for (EmployeeEntity employeeEntity : employeesList) {
            Employee employee = new Employee();
            // get the important data from the entity and set it to the model
            employee.setId(employeeEntity.getId());
            employee.setName(employeeEntity.getName());
            employee.setPhone(employeeEntity.getPhone());
            employee.setEmail(employeeEntity.getEmail());
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        // Do it like this or first find the entity with Id and delete it.
        // employeeRepository.deleteById(id);
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);

        // employees.remove(id);
        return true;
    }

    @Override
    public String updateEmployee(Employee employee, Long id) {
        EmployeeEntity existingEmployeeEntity = employeeRepository.findById(id).get();

        existingEmployeeEntity.setName(employee.getName());
        existingEmployeeEntity.setPhone(employee.getPhone());
        existingEmployeeEntity.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployeeEntity);
        return "Update Successfully";
    }

}
