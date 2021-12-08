package com.example.TravelApplication.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.TravelApplication.Entity.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {	 
		
		Employee employee = new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setContact(rs.getString(3));
		employee.setGender(rs.getString(4));
		employee.setEmail(rs.getString(5));
        return employee;
	}
}
