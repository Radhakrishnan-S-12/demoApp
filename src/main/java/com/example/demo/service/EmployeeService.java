package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee getEmployee(Integer employeeID) {
        if (employeeRepo.findById(employeeID).isPresent()) {
            return employeeRepo.findById(employeeID).get();
        }
        else
            return new Employee();
    }

    public List<Employee> getWorkingEmployees(){
        return employeeRepo.getAllActiveEmployee();
    }

    public Employee saveEmployee(Employee employeeDetails){
        return employeeRepo.save(employeeDetails);
    }
}
