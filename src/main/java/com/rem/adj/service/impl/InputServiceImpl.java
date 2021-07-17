package com.rem.adj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rem.adj.entity.InputDetailsEntity;
import com.rem.adj.model.GetAllDetailsResponse;
import com.rem.adj.repo.InputDetailsRepo;
import com.rem.adj.service.InputService;

@Service
public class InputServiceImpl implements InputService {

	@Autowired
	InputDetailsRepo inputRepo;
	
	Mapper mapper;

	@Override
	public List<GetAllDetailsResponse> getAllDetails() {
		List<GetAllDetailsResponse> allDetailsResponses = new ArrayList<GetAllDetailsResponse>();
		
		List<InputDetailsEntity> detailsEntities = inputRepo.findAll();
		
		detailsEntities.stream().forEach(entity->{
			GetAllDetailsResponse res = new GetAllDetailsResponse();
			res.setId(entity.getId());
			res.setInput_string(entity.getInput_string());
			allDetailsResponses.add(res);
		});
		
		return allDetailsResponses;
	}

}
