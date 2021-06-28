package com.EmployeeApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void insertEmployee(EmployeeDTO employeeDTO) {
		Employee emp = new Employee();
		emp.setEmpId(employeeDTO.getEmpId());
		emp.setEmpName(employeeDTO.getEmpName());
		emp.setEmpPhone(employeeDTO.getEmpPhone());
		employeeRepository.save(emp);
		
	}

	@Override
	public Iterable<Employee> displayEmployee() {
		Iterable<Employee>employeeList=employeeRepository.findAll();
		return employeeList;
		
	}

}
