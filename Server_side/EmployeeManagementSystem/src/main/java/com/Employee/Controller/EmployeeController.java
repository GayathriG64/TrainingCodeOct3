package com.Employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
		
		ResponseEntity<Employee> responseEntity= new ResponseEntity<>(HttpStatus.OK);
		try {
			employeeService.deleteEmployee(id);
		}
		catch(Exception e){
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@PutMapping("/updateEmp/{id}")
	
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee employee){
		Employee updatedEmployee= employeeService.updateEmployee(employee, id);
		ResponseEntity<Employee> responseEntity =new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
		return responseEntity;
	}
}
