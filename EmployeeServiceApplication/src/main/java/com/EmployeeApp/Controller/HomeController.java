package com.EmployeeApp.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String registerEmployee(@RequestBody EmployeeDTO employee) {
		employeeService.insertEmployee(employee);
		
		return "Employee successfully registered";
	}
	
	@GetMapping("/displayEmployee")
	public Iterable<Employee> displayEmployee(){
		return employeeService.displayEmployee();
		
	}
}
