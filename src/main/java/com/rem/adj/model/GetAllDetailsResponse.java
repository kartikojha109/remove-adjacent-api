package com.rem.adj.model;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class GetAllDetailsResponse {

	private String input_string;
	private long id;
	
	public String getInput_string() {
		return input_string;
	}
	public void setInput_string(String input_string) {
		this.input_string = input_string;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
