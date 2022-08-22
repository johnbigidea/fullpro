package com.app.service;

import com.app.model.Complex;
import com.app.model.Employee;
import com.app.model.Imagine;

import java.util.List;

public interface ImagineService {
	
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Integer employeeId);
	public boolean isExsits(Integer employeeId);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer employeeId);
	public List<Employee> findEmployeeByName(String name);

}
