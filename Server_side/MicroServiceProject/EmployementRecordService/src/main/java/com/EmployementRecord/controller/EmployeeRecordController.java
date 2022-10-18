package com.EmployementRecord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployementRecord.entity.EmployementRecord;
import com.EmployementRecord.service.IRecordService;
import com.EmployementRecord.service.RecordServiceImpl;

@RestController
@RequestMapping("/record")
public class EmployeeRecordController {

	@Autowired
	private IRecordService recordService;
	
	@GetMapping("/emp/{empID}")
	public List<EmployementRecord> getEmployementRecord(@PathVariable("empID") Long empID){
		return recordService.getRecordOfEmployee(empID);
	}
	
}
