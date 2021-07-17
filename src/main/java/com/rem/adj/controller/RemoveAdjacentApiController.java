package com.rem.adj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rem.adj.model.GetAllDetailsResponse;
import com.rem.adj.service.InputService;
import com.rem.adj.service.OutputService;

@RestController
@RequestMapping("/api")
public class RemoveAdjacentApiController {

	@Autowired
	InputService iService;

	@Autowired
	OutputService oService;

	@GetMapping("/get-all")
	public ResponseEntity<List<GetAllDetailsResponse>> getAll() {

		List<GetAllDetailsResponse> responses = iService.getAllDetails();

		return new ResponseEntity<>(responses, HttpStatus.OK);

	}

	@PutMapping("/process-all-records")
	public ResponseEntity<String> processAll() {

		try {
			oService.processRecords();
		} catch (Exception e) {

		}
		return new ResponseEntity<>("Processed All Records!!", HttpStatus.OK);

	}
	
	/* Just to flush the data */
	@DeleteMapping("/delete-all-processed-records")
	public ResponseEntity<String> deleteProcessedAll() {

		try {
			oService.deleteProcessedRecords();
		} catch (Exception e) {

		}
		return new ResponseEntity<>("All Processed Records Deleted!!", HttpStatus.OK);

	}
}
