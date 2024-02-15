package com.learn.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.entity.Department;
import com.learn.springboot.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/department/save")
	public Department saveDepartment(@RequestBody Department department)
	{
		log.info("department details are saved");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/department/retrieve/{id}")
	public Department findDepartmentById(@PathVariable int id)
	{
		log.info("department details are retrieved");
		return departmentService.findDepartmentById(id);
	}
	

}
