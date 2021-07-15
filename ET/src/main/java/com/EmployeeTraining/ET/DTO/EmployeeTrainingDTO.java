package com.EmployeeTraining.ET.DTO;

import javax.validation.constraints.NotNull;

public class EmployeeTrainingDTO {

	@NotNull(message="Training Code cannot be Null")
	private Integer trainingCode;
	@NotNull(message="Training Couse cannot be Null")
	private String course;
	@NotNull(message="Employee Id cannot be Null")
	private Integer employeeId;
	
	public EmployeeTrainingDTO() {
	}

	public EmployeeTrainingDTO(Integer trainingCode, String course, Integer employeeId) {
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

	@Override
	public String toString() {
		return "EmployeeTrainingDTO [trainingCode=" + trainingCode + ", course=" + course + ", employeeId=" + employeeId
				+ "]";
	}
	
	
	
	
}
