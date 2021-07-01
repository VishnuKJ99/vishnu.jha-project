package com.EmployeeApp.Service;

import java.util.List;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Exception.EmployeeException;

public interface EmployeeService {

	public void insertEmployee(EmployeeDTO employeeDTO);
	
	public Iterable<Employee> displayEmployee();
	
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeException;
	
	public void removeEmployee(Integer employeeId) throws EmployeeException;
}
