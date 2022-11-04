package com.digitalbooks.service;

import com.digitalbooks.entity.Reader;

public interface IReaderService {
	public Reader saveReader(Reader reader);
	public Reader getReaderByEmailId(String emailId);
	public Reader getReaderByREaderId(Long readerID);
}
