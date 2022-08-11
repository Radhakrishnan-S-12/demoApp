package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;  

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

    @Query(value="select * from EMPLOYEE_TABLE where WORKING_STATUS = TRUE", nativeQuery = true )
    public List<Employee> getAllActiveEmployee();
}
