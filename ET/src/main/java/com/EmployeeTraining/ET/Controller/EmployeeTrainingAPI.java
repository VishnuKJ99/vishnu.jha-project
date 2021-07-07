package com.EmployeeTraining.ET.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeTraining.ET.DTO.EmployeeTrainingDTO;
import com.EmployeeTraining.ET.Entity.EmployeeTrainingEntity;
import com.EmployeeTraining.ET.Exception.EmployeeTrainingException;
import com.EmployeeTraining.ET.Service.EmployeeTrainingService;

@RestController
@CrossOrigin
@RequestMapping("/training")
public class EmployeeTrainingAPI {
	
	@Autowired
	EmployeeTrainingService service;
	
	@PostMapping("/")
	public ResponseEntity<String> registerEmployee(EmployeeTrainingDTO employeeDTO) throws EmployeeTrainingException {
		service.registerEmployeeForTraining(employeeDTO);
		return new ResponseEntity<>("Employee Registered For Training Succesfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Iterable<EmployeeTrainingEntity>> getAllEmployee() throws EmployeeTrainingException{
		return new ResponseEntity<>(service.getEmployeesInTraining(),HttpStatus.OK);
		
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testRestTemplate(){
		return new ResponseEntity<>("hello from training",HttpStatus.OK);
	}
	
}
