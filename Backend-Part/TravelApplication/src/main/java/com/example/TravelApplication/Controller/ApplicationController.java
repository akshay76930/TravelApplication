package com.example.TravelApplication.Controller;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.TravelApplication.Entity.Employee;
import com.example.TravelApplication.Service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ApplicationController {
	
	@Resource
	EmployeeService employeeService;
	
	@GetMapping(value = "/allEmployee")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}
	
	@PostMapping(value = "/insertEmployee")
	public Employee insertEmployee(@RequestBody Employee employee) {
		System.out.print("hello");
		employeeService.insertEmployee(employee);
		return employee;
	}	
	
	@PutMapping(value = "/updateEmployee")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping(value = "/deleteEmployeeById")
	public void deleteEmployee(Employee employee) {
		employeeService.deleteEmployee(employee);
	}


//	@GetMapping("/employeeName")
//	public String getEmployeeName(@RequestParam String id,String password) {
//		return employeeService.getName(id, password);
//	}
}
	