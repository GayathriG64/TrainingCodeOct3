package com.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Entity.Employee;
import com.Employee.Exception.ResourceNotFoundException;

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

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Employee updatedEmployee = employeeRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "id", id)
				);
		//updatedEmployee.setId(employee.getId());	
		updatedEmployee.setName(employee.getName());
		updatedEmployee.setEmp_position(employee.getEmp_position());
		updatedEmployee.setQualification(employee.getQualification());
		updatedEmployee.setSalary(employee.getSalary());
		employeeRepo.save(updatedEmployee);
		return updatedEmployee;
	}
	
}
