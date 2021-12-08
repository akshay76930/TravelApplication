package com.example.TravelApplication.Service;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.example.TravelApplication.Dao.EmployeeDao;
import com.example.TravelApplication.Entity.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Resource 
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
	   employeeDao.updateEmployee(employee);	
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(employee);
	}


	/*
	 * public String getName(String id,String password) {
	 * 
	 * return employeeDao.getName(id,password); }
	 */
	
}
