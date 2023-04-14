package com.api.backend.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.model.Employee;
import com.api.backend.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/employees")
	public List<Employee> list(){
		return employeeService.listAll();
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> get(@PathVariable Long id) {
		try
		{
			Employee emp = employeeService.get(id);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/employees")
	public void add(@Valid @RequestBody Employee emp, BindingResult bindingresult) {
		
		employeeService.save(emp);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@PutMapping("/employees/{id}")
	public Employee updateProduct(@RequestBody Employee emp,BindingResult bindingresult,@PathVariable("id") long id){
		return employeeService.updateEmployee(emp,id);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("/employees/{id}")
	public void deleteStudent(@PathVariable("id") long id)
	{
		employeeService.deleteEmployee( id);	
	}


}
