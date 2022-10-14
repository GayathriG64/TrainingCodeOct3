package com.Employee.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer>{

}
