package com.api.backend.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.backend.model.Employee;
import com.api.backend.repository.EmployeeReository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeReository repo;
	
	public List<Employee> listAll(){
		return repo.findAll();
	}
	public void save(Employee emp) {
		repo.save(emp);
	}
	
	public Employee get(Long id) {
		return repo.findById(id).get();
	}
	
	public Employee updateEmployee(Employee emp, long id)
	{
		Employee stud=repo.findById(id).get();
		if(Objects.nonNull(emp.getFirstName())
				&& !"".equalsIgnoreCase(emp.getFirstName())) {
			stud.setFirstName(emp.getFirstName());
		}
		if(Objects.nonNull(emp.getId())) {
			stud.setId(emp.getId());
		}
		if(Objects.nonNull(emp.getLastName())
				&& !"".equalsIgnoreCase(emp.getLastName())) {
			stud.setLastName(emp.getLastName());
		}
		if(Objects.nonNull(emp.getEmailId())
				&& !"".equalsIgnoreCase(emp.getEmailId())) {
			stud.setEmailId(emp.getEmailId());
		}
		return repo.save(emp);
	}

	public void deleteEmployee(long id) {
		repo.deleteById(id);	
	}

}
