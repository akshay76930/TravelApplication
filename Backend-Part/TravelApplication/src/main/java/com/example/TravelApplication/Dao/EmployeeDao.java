package com.example.TravelApplication.Dao;

import java.util.List;

import com.example.TravelApplication.Entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();

	void insertEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(Employee employee);

//	public String getName (String id,String password);



}
