package com.rem.adj.model;

import java.util.Date;

public class ProcessedObject {
	
	private int steps;
	private String original_string;
	private String processed_string;
	private Date creation_time = new Date();

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public String getOriginal_string() {
		return original_string;
	}

	public void setOriginal_string(String original_string) {
		this.original_string = original_string;
	}

	public String getProcessed_string() {
		return processed_string;
	}

	public void setProcessed_string(String processed_string) {
		this.processed_string = processed_string;
	}

	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}

}
