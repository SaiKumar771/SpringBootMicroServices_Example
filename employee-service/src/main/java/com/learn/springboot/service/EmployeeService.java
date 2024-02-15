package com.learn.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.springboot.dao.Department;
import com.learn.springboot.dao.ResponseDao;
import com.learn.springboot.entity.Employee;
import com.learn.springboot.repository.IEmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	
	public ResponseDao getEmployeeAlongWithDepartment(int id) {
		ResponseDao response=new ResponseDao();
		
		Employee employee=employeeRepo.findById(id).get();
		Department dept=restTemplate.getForObject("http://department-service/departments/department/retrieve/"+employee.getDepartmentId(), Department.class);
		
		response.setDepartment(dept);
		response.setEmployee(employee);
		return response;
	}



	
}
