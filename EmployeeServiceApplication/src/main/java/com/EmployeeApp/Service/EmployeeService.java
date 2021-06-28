package com.EmployeeApp.Service;

import java.util.List;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Entity.Employee;

public interface EmployeeService {

	public void insertEmployee(EmployeeDTO employeeDTO);
	
	public Iterable<Employee> displayEmployee();
}
