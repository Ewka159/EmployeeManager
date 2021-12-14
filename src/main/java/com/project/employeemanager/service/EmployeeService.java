package com.project.employeemanager.service;

import com.project.employeemanager.exception.UserNotFoundException;
import com.project.employeemanager.model.Employee;
import com.project.employeemanager.repo.EmployeeRepo;
import com.project.employeemanager.utils.EmailValidator;
import com.project.employeemanager.utils.PhoneNumberValidator;
import com.project.employeemanager.utils.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final PhoneNumberValidator phoneNumberValidator;
    private final EmailValidator emailValidator;
    private final UrlValidator urlValidator;


    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, PhoneNumberValidator phoneNumberValidator, EmailValidator emailValidator, UrlValidator urlValidator) {
        this.employeeRepo = employeeRepo;
        this.phoneNumberValidator = phoneNumberValidator;
        this.emailValidator = emailValidator;
        this.urlValidator = urlValidator;
    }

    public Employee addEmployee(Employee employee) {
        if (!phoneNumberValidator.test(employee.getPhone())){
            throw new IllegalStateException("Phone is not valid");
        }
        else if (!emailValidator.test(employee.getEmail())) {
            throw new IllegalStateException("Email is not valid");
        }
        else if (!urlValidator.test(employee.getImageUrl())) {
            throw new IllegalStateException("Url is not valid");
        }
        else if (employee.getSalary() < 100000000 && employee.getSalary() > 0){
            throw new IllegalStateException("Wrong number");
        }
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        if (!phoneNumberValidator.test(updatedEmployee.getPhone())){
            throw new IllegalStateException("Phone is not valid");
        }
        else if (!emailValidator.test(updatedEmployee.getEmail())) {
            throw new IllegalStateException("Email is not valid");
        }
        else if (!urlValidator.test(updatedEmployee.getImageUrl())) {
            throw new IllegalStateException("Url is not valid");
        }
        else if (updatedEmployee.getSalary() < 100000000 && updatedEmployee.getSalary() > 0){
            throw new IllegalStateException("Wrong number");
        }
        return employeeRepo.findEmployeeById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setLastname(updatedEmployee.getLastname());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setSalary(updatedEmployee.getSalary());
                    employee.setImageUrl(updatedEmployee.getImageUrl());
                    employee.setPhone(updatedEmployee.getPhone());
                    employee.setJobTitle(updatedEmployee.getJobTitle());
                    return employeeRepo.save(employee);
                })
                .orElseGet(() -> employeeRepo.save(updatedEmployee));
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
