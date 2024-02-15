package com.learn.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/employeeServiceFallback")
	public String employeeServiceFallback()	{
		return "Employee service taking time to responding.Please try after sometime !.";
	}
    
	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallback()
	{
		return "Department service taking time to responding.Please try after sometime !.";
	}
}
