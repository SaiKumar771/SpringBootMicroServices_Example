package com.learn.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.entity.Department;
import com.learn.springboot.repository.IDepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepo;

	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Department findDepartmentById(int id) {

		return departmentRepo.findById(id).get();
	}

}
