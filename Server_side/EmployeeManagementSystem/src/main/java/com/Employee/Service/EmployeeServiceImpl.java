package com.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	IEmployeeRepo employeeRepo;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepo.save(employee);
		return savedEmployee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeRepo.findAll();
		return employeeList;
	}

	@Override
	public Optional<Employee> getEmployee(Integer id) {
		return employeeRepo.findById(id);
	}
	
}
