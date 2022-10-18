package com.Employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Employee.Entity.Employee;
import com.Employee.Entity.EmployementRecord;


public interface IEmployeeService {
	public Employee getEmployee(Long id);
	
	
}
