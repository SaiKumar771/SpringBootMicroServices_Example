package com.learn.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.dao.ResponseDao;
import com.learn.springboot.entity.Employee;
import com.learn.springboot.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServcie;
	
	private static final String  employee_service="employee-service";
	
	@PostMapping("emp/save")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		log.info("Saved Employee details");
		return employeeServcie.saveEmployee(employee);
	}
	
	@GetMapping("emp/retrieve/{id}")
	@CircuitBreaker(name = "employee_service",fallbackMethod = "employeeServiceFallback")
	public ResponseDao getEmployeeAlongWithDepartment(@PathVariable int id)
	{
		log.info("Employee details retrieved");
		return employeeServcie.getEmployeeAlongWithDepartment(id);
	}
	
	public ResponseDao employeeServiceFallback(Exception e)
	{
		return new ResponseDao("Server is not responding!Try after some time");
	}
    
	

}
