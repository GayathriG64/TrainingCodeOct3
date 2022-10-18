package com.Employee.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.Employee.Entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	
	
	private List<Employee> employeeList= List.of(
			new Employee(1111L, "GayathriG1","9876543210" ),
			new Employee(1111L, "GayathriG2","9876543210" ),
			new Employee(1112L, "GayathriG3","9876543210" ),
			new Employee(1113L, "GayathriG4","9876543210" ),
			new Employee(1114L, "GayathriG5","9876543210" ),
			new Employee(1115L, "GayathriG6","9876543210" ),
			new Employee(1116L, "GayathriG7","9876543210" )
			);
	
	@Override
	public Employee getEmployee(Long id) {
		
	Employee emp = employeeList.stream().filter((e)->e.getEmpID().equals(id)).findAny().orElse(null);
		return emp;
	}

	
}
