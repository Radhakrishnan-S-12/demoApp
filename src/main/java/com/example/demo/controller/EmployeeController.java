package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/getEmployee/{employeeID}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable Integer employeeID) {
        Employee employeeDetails = employeeService.getEmployee(employeeID);
        if (Objects.nonNull(employeeDetails.getEmployeeId())) {
            return new ResponseEntity<Employee>(employeeDetails, HttpStatus.OK);
        } else
            return new ResponseEntity<Employee>(employeeDetails, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getWorkingEmployees")
    public ResponseEntity<List<Employee>> getWorkingEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getWorkingEmployees(), HttpStatus.OK);
    }

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }
}