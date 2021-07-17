package com.rem.adj.service;

import org.springframework.stereotype.Service;

@Service
public interface OutputService {
	
	void processRecords();
	
	void deleteProcessedRecords();

}
