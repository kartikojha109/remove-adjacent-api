package com.rem.adj.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rem.adj.model.GetAllDetailsResponse;

@Service
@Component
public interface InputService {

	List<GetAllDetailsResponse> getAllDetails();
}
