package com.EmployeeApp.DTO;

import javax.validation.constraints.NotNull;

public class EmployeeDTO {

	@NotNull(message="Employee ID cannot be empty")
	private Integer empId;
	@NotNull(message="Employee Name cannot be empty")
	private String empName;
	@NotNull(message="Employee Phone NO. cannot be empty")
	private Long empPhone;
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(Integer empId, String empName, Long empPhone) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(Long empPhone) {
		this.empPhone = empPhone;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + "]";
	}
	
}
