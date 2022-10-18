package com.EmployementRecord.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.EmployementRecord.entity.EmployementRecord;

@Service
public class RecordServiceImpl implements IRecordService{
	
	List<EmployementRecord> list = List.of(
			new EmployementRecord(10101L,"Wipro","wipro@gmail.com",3,1111L),
			new EmployementRecord(10102L,"TCS","tcs@gmail.com",5,1112L),
			new EmployementRecord(10103L,"Infosys","infosys@gmail.com",6,1113L),
			new EmployementRecord(10104L,"DELL","dell@gmail.com",2,1113L),
			new EmployementRecord(10105L,"Google","google@gmail.com",4,1115L),
			new EmployementRecord(10106L,"Deloitte","deloitte@gmail.com",7,1116L),
			new EmployementRecord(10107L,"Cognizant","cognizant@gmail.com",1,1116L),
			new EmployementRecord(10108L,"Facebook","facebook@gmail.com",8,1118L)
		);
	
	
	@Override
	public List<EmployementRecord> getRecordOfEmployee(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(e->e.getEmpID().equals(id)).collect(Collectors.toList());
	}

}
