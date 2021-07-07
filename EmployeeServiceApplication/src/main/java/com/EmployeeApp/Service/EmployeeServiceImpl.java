package com.EmployeeApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Exception.EmployeeException;
import com.EmployeeApp.Repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void insertEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
		Optional<Employee> employee=employeeRepository.findById(employeeDTO.getEmpId());
		if(employee.isEmpty()==true) {
		Employee emp = new Employee();
		emp.setEmpId(employeeDTO.getEmpId());
		emp.setEmpName(employeeDTO.getEmpName());
		emp.setEmpPhone(employeeDTO.getEmpPhone());
		employeeRepository.save(emp);
		}
		else {
			throw new EmployeeException("Employee Already Exists");
		}
	}

	@Override
	public List<EmployeeDTO> displayEmployee() {
		Iterable<Employee>employeeList=employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		for(Employee emp : employeeList) {
			EmployeeDTO empDTO= new EmployeeDTO(emp.getEmpId(),emp.getEmpName(),emp.getEmpPhone());
			employeeDTOList.add(empDTO);
		}
		return employeeDTOList;
		
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeException {
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		Employee emp=employee.orElseThrow(() -> new EmployeeException("Employee Not Found"));
		EmployeeDTO employeeDTO=new EmployeeDTO(emp.getEmpId(),emp.getEmpName(),emp.getEmpPhone());
		
		return employeeDTO ;
	}

	@Override
	public void removeEmployee(Integer employeeId) throws EmployeeException {
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		Employee emp=employee.orElseThrow(() -> new EmployeeException("Employee Not Found"));	
		employeeRepository.deleteById(employeeId);
	}
	

}
