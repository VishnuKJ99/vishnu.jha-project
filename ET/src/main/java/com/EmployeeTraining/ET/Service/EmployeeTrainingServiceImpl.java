package com.EmployeeTraining.ET.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeTraining.ET.DTO.EmployeeTrainingDTO;
import com.EmployeeTraining.ET.Entity.EmployeeTrainingEntity;
import com.EmployeeTraining.ET.Exception.EmployeeTrainingException;
import com.EmployeeTraining.ET.Repository.EmployeeTrainingRepository;

@Service
@Transactional
public class EmployeeTrainingServiceImpl implements EmployeeTrainingService {
	
	@Autowired
	private EmployeeTrainingRepository repo;

	@Override
	public Iterable<EmployeeTrainingEntity> getEmployeesInTraining() throws EmployeeTrainingException {
		Iterable<EmployeeTrainingEntity> employeeTrainingList=repo.findAll();
		return employeeTrainingList;
	}

	@Override
	public void registerEmployeeForTraining(EmployeeTrainingDTO employee) throws EmployeeTrainingException {
		Optional<EmployeeTrainingEntity> optEmployee=repo.findById(employee.getEmployeeId());
		if(optEmployee.isEmpty()==false)
			throw new EmployeeTrainingException("Employee is already in a training program ");
		EmployeeTrainingEntity emp=new EmployeeTrainingEntity(employee.getTrainingCode(),employee.getCourse(),employee.getEmployeeId());
		repo.save(emp);
		
	}

}
