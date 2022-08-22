package com.app.dao;

import com.app.model.Employee;
import com.app.model.Simple;

import java.util.List;

public interface SimpleDao {
	
	public void addEmployee(Employee employee);
	public List<Employee> getEmployees();
	public List<Employee> findEmployeeByName(String name);
	public Employee findEmployeeById(int employeeId);
	public boolean existsById(Integer id);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer employeeId );

}
