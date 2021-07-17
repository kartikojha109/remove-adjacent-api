package com.rem.adj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kartik_ojha_java_output_new")
public class OutputEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "orignal_string")
	private String input_string;
	
	@Column(name = "processed_string")
	private String processed_string;
	
	@Column(name = "steps_taken")
	private int steps_taken;
	
	@Column(name = "creation_time")
	private Date creation_time = new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInput_string() {
		return input_string;
	}

	public void setInput_string(String input_string) {
		this.input_string = input_string;
	}

	public String getProcessed_string() {
		return processed_string;
	}

	public void setProcessed_string(String processed_string) {
		this.processed_string = processed_string;
	}

	public int getSteps_taken() {
		return steps_taken;
	}

	public void setSteps_taken(int steps_taken) {
		this.steps_taken = steps_taken;
	}

	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}

}
