package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "EmployeeTable")
@Entity
public class Employee {
    @Column(name = "EmployeeName")
    private String employeeName;

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "WorkingStatus")
    private boolean activeStatus;

}
