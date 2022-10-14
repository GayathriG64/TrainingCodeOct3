package com.Employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello World";
	}
	
	@PostMapping("/saveEmp")
	public Integer createEmployee(@RequestBody Employee employee) {
		Integer id = employeeService.saveEmployee(employee);
		System.out.println("Saved ID: "+id);
		return id;
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	 
	@GetMapping("/getEmp/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id){
		Optional<Employee> employee =employeeService.getEmployee(id);
		
		return employee;
	}
}
