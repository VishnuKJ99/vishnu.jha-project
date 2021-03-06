package com.EmployeeApp.Service;

import java.util.List;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Exception.EmployeeException;

public interface EmployeeService {

	public void insertEmployee(EmployeeDTO employeeDTO) throws EmployeeException;
	
	public List<EmployeeDTO> displayEmployee();
	
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeException;
	
	public void removeEmployee(Integer employeeId) throws EmployeeException;

	public Object getEmployeev2(Integer employeeId) throws EmployeeException;
}
