package com.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Employee.Entity.Employee;
import com.Employee.Entity.EmployementRecord;
import com.Employee.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getEmployee/{empID}")
	public Employee getAllEmpoyees(@PathVariable Long empID){
		Employee employee =employeeService.getEmployee(empID);
		List record= restTemplate.getForObject("http://localhost:8082/record/emp/"+ empID, List.class);
		employee.setEmploymentRecord(record);
		return employee;
	}
	
}
