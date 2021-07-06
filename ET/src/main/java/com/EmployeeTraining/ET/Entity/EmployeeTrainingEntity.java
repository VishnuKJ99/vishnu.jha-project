package com.EmployeeTraining.ET.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeTrainingEntity {

	@Id
	private Integer trainingCode;
	private String course;
	private Integer employeeId;
	
	public EmployeeTrainingEntity() {
	}
	
	public EmployeeTrainingEntity(Integer trainingCode, String course, Integer employeeId) {
		super();
		this.trainingCode = trainingCode;
		this.course = course;
		this.employeeId = employeeId;
	}

	public Integer getTrainingCode() {
		return trainingCode;
	}

	public void setTrainingCode(Integer trainingCode) {
		this.trainingCode = trainingCode;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
