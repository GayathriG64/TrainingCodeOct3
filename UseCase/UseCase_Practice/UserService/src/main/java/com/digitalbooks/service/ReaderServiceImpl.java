package com.digitalbooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Reader;
import com.digitalbooks.repository.IReaderRepo;

@Service
public class ReaderServiceImpl implements IReaderService{
	@Autowired
	IReaderRepo readerRepo;
	@Override
	public Reader saveReader(Reader reader) {
		Reader savedReader=readerRepo.save(reader);
		return savedReader;
	}
	@Override
	public Reader getReaderByEmailId(String emailId) {
		Reader reader = readerRepo.findByEmailId(emailId);
		return reader;
	}
	@Override
	public Reader getReaderByREaderId(Long readerID) {
		Reader reader = readerRepo.findById(readerID).orElse(null);
		return reader;
	}

}
