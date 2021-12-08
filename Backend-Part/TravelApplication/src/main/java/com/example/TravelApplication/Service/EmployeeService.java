package com.example.TravelApplication.Service;

import java.util.List;

import com.example.TravelApplication.Entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	void insertEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
}
