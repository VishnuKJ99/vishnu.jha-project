package com.EmployeeTraining.ET.Service;

import java.util.List;

import com.EmployeeTraining.ET.DTO.EmployeeTrainingDTO;
import com.EmployeeTraining.ET.Entity.EmployeeTrainingEntity;
import com.EmployeeTraining.ET.Exception.EmployeeTrainingException;

public interface EmployeeTrainingService {
	
	public Iterable<EmployeeTrainingEntity> getEmployeesInTraining() throws EmployeeTrainingException;
	public void registerEmployeeForTraining(EmployeeTrainingDTO employee) throws EmployeeTrainingException;
	public EmployeeTrainingEntity getEmployeeById(Integer trainingCode) throws EmployeeTrainingException;
}
