package com.EmployeeApp.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private Integer empId;
	private String empName;
	private Long empPhone;
	public Employee(Integer empId, String empName, Long empPhone) {
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
	
}
