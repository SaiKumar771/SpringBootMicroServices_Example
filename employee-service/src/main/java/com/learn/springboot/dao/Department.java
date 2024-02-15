package com.learn.springboot.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	int departmentId;
	String departmentName;
	String departmentLocation;

}
