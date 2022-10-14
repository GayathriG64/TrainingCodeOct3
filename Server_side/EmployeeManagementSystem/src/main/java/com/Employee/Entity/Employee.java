package com.Employee.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer salary;
	private String name;
	private String emp_position;
	private String qualification;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmp_position() {
		return emp_position;
	}
	public void setEmp_position(String emp_position) {
		this.emp_position = emp_position;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Employee(Integer id, Integer salary, String name, String emp_position, String qualification) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.emp_position = emp_position;
		this.qualification = qualification;
	}
	public Employee() {
		super();
	}
	
}
