package com.EmployementRecord.service;

import java.util.List;

import com.EmployementRecord.entity.EmployementRecord;

public interface IRecordService {
	public List<EmployementRecord> getRecordOfEmployee(Long id);
	
}
