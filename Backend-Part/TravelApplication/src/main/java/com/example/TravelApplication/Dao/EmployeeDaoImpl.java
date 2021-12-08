package com.example.TravelApplication.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.example.TravelApplication.Entity.Employee;
import com.example.TravelApplication.Mapper.EmployeeMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl(NamedParameterJdbcTemplate template, JdbcTemplate temp) {
		this.template = template;
		this.temp = temp;
	}


	NamedParameterJdbcTemplate template;
	JdbcTemplate temp;
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return template.query("select * from employee",new EmployeeMapper());
	}

	
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		final String sql = "insert into employee(name,contact,gender,email) values(:name,:contact,:gender,:email)";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", employee.getName())
				.addValue("contact", employee.getContact()).addValue("gender", employee.getGender())
				.addValue("email", employee.getEmail());

		System.out.print(sql);
		template.update(sql, param, holder);
  }


	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println(employee.getName());
		System.out.println(employee.getContact());
		System.out.println(employee.getId());
		System.out.println(employee.getGender());
		System.out.println(employee.getEmail());
			
		final String sql = "update employee set name=:name,email=:email,contact=:contact,gender=:gender where id=:id";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", employee.getId()).addValue("name", employee.getName()).addValue("contact", employee.getContact()).addValue("email", employee.getEmail()).addValue("gender", employee.getGender());

		System.out.println(employee.getName());
		System.out.print(sql);
		template.update(sql, param, holder);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		final String sql = "delete from employee where id=:id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", employee.getId());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}

//	/*
//	 * @Override public String getName(String id, String password) {
//	 * 
//	 * String sql = "SELECT * FROM employee WHERE id=" + id + " and password=" +
//	 * password; return this.temp.query(sql, new ResultSetExtractor<String>() {
//	 * public String extractData(ResultSet resultSetObj) throws SQLException,
//	 * DataAccessException { String s = ""; if (resultSetObj.next()) { s =
//	 * resultSetObj.getString("name");// column name return s; } else { return s =
//	 * "Not Found"; } } }); }
//	 */
}