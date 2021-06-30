package com.EmployeeApp.Controller;

import javax.transaction.Transactional;

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
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Service.EmployeeService;

@RestController
@CrossOrigin

public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/registerEmployee")
	@Transactional
	public ResponseEntity<String> registerEmployee(@RequestBody EmployeeDTO employee) {
		employeeService.insertEmployee(employee);
		
		return new ResponseEntity<>("Employee Creation Successful",HttpStatus.CREATED);
	}
	
	@GetMapping("/displayEmployee")
	public ResponseEntity<Iterable<Employee>> displayEmployee(){
		return new ResponseEntity<>(employeeService.displayEmployee(),HttpStatus.OK);
		
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer employeeId){
		
		return new ResponseEntity<>(employeeService.getEmployee(employeeId),HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/delete/{employeeId}")
	public ResponseEntity<String> removeEmployee(@PathVariable Integer employeeId){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
