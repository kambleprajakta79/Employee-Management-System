package com.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.backend.model.Employee;

public interface EmployeeReository extends JpaRepository<Employee, Long>{
	

}
