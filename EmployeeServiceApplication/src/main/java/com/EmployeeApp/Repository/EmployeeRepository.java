package com.EmployeeApp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.EmployeeApp.Entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
