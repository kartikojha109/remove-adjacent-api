package com.rem.adj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rem.adj.entity.InputDetailsEntity;
import com.rem.adj.entity.OutputEntity;
import com.rem.adj.model.ProcessedObject;
import com.rem.adj.repo.InputDetailsRepo;
import com.rem.adj.repo.OutputDetailsRepo;
import com.rem.adj.service.OutputService;

@Service
public class OutputServiceImpl implements OutputService {

	@Autowired
	InputDetailsRepo iDetailsRepo;
	
	@Autowired
	OutputDetailsRepo oDetailsRepo;
	
	@Override
	public void processRecords() {
		List<InputDetailsEntity> listInput = iDetailsRepo.findAll();
		
		listInput.stream().forEach(entity ->{
			OutputEntity oEntity = new OutputEntity();
			ProcessedObject pObject = operate(entity);
			oEntity.setCreation_time(pObject.getCreation_time());
			oEntity.setInput_string(pObject.getOriginal_string());
			oEntity.setProcessed_string(pObject.getProcessed_string());
			oEntity.setSteps_taken(pObject.getSteps());
			oDetailsRepo.save(oEntity);
		});
	}
	
	ProcessedObject operate(InputDetailsEntity detailsEntity) {
		
		ProcessedObject object = new ProcessedObject();
		String s  = detailsEntity.getInput_string();
		s = s.trim().replaceAll(" +", " ");
		int step = 0;
		int i = 0;

		while(true) {
			char ourChar = s.charAt(i);  
			if(ourChar == s.charAt(i+1) || s.charAt(i+1) == ' ') {
				int j = i;
				while( j < s.length()-1 && (ourChar == s.charAt(j+1) || s.charAt(j+1) == ' ')) {
					if(s.charAt(j+1) == ' ') {
						if(s.charAt(j) == s.charAt(j+2)) {
							j++;
						}else 
							break;
						
						}
					j++;
				}
				if(i < j) {
				s = remove(i,j,s);
					i = -1;
					step++;
				}
			}
			i++;
			if(i == s.length()-1) {
				break;
			}
		}
		object.setProcessed_string(s);
		object.setOriginal_string(detailsEntity.getInput_string());
		object.setSteps(step);
		object.setCreation_time(new Date());
		
		return object;
	}
	
	static String remove(int i, int j, String s) {
		s = s.substring(0,i) + s.substring(j+1,s.length());
		return s;
	}

	@Override
	public void deleteProcessedRecords() {
		oDetailsRepo.deleteAll();
	}
	
}
