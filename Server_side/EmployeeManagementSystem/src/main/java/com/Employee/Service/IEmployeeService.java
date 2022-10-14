package com.Employee.Service;

import java.util.List;
import java.util.Optional;

import com.Employee.Entity.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	Optional<Employee> getEmployee(Integer id);
}
