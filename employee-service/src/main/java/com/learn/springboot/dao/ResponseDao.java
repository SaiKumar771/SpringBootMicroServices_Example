package com.learn.springboot.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.learn.springboot.entity.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseDao {
	
	@JsonIgnoreProperties
	private String fallBackMsg;
	
	private Employee employee;
	private Department department;
	public ResponseDao(Employee employee, Department department) {
		super();
		this.employee = employee;
		this.department = department;
	}
	public ResponseDao(String fallBackMsg) {
		super();
		this.fallBackMsg = fallBackMsg;
	}
	
}
