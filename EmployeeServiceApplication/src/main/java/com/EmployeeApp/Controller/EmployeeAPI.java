package com.EmployeeApp.Controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Exception.EmployeeException;
import com.EmployeeApp.Service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/employee")
@Api(value = "EmployeeController, REST APIs that deal with Employee DTO")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/")
	@ApiOperation(value = "Register details of Employee")
	public ResponseEntity<String> registerEmployee(@Valid @RequestBody EmployeeDTO employee) throws EmployeeException  {
		employeeService.insertEmployee(employee);
		return new ResponseEntity<>("Employee Creation Successful",HttpStatus.CREATED);
	}
	
	@GetMapping(value="/")
	@ApiOperation(value = "Fetch details of all Employee")
	public ResponseEntity<List<EmployeeDTO>> displayEmployee(){
		return new ResponseEntity<>(employeeService.displayEmployee(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{employeeId}",params = "version=1")
	@ApiOperation(value = "Fetch details of Employee by EmployeeID")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer employeeId) throws EmployeeException {
		
		return new ResponseEntity<>(employeeService.getEmployee(employeeId),HttpStatus.OK);
	}
	
	@GetMapping(value="/{employeeId}",params = "version=2")
	@ApiOperation(value = "Fetch details of Employee by EmployeeID")
	public ResponseEntity<Object> getEmployeeByIdv2(@PathVariable Integer employeeId) throws EmployeeException {
		Object employee=employeeService.getEmployeev2(employeeId);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employeeId}")
	@ApiOperation(value = "Delete an Employee")
	public ResponseEntity<String> removeEmployee(@PathVariable Integer employeeId) throws EmployeeException {
		employeeService.removeEmployee(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> trainEmployee() {
		String uri = "http://localhost:8081/training/test";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
