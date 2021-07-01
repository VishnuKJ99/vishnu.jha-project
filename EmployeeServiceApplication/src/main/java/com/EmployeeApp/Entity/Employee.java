package com.EmployeeApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	private Long empPhone;
	
	public Employee() {}
	
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + "]";
	}
	
	
}
