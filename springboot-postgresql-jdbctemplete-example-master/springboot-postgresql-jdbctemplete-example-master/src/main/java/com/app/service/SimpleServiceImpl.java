package com.app.service;

import com.app.dao.SimpleDao;
import com.app.model.Complex;
import com.app.model.Employee;
import com.app.model.Simple;
import com.app.model.Wrongway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleServiceImpl implements SimpleService {
	@Autowired
	private SimpleDao employeeDao;

	public void saveEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}

	public List<Employee> getAllEmployees() {
		
		return employeeDao.getEmployees();
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee=employeeDao.findEmployeeById(employeeId);
		return employee;
	}

	@Override
	public boolean isExsits(Integer employeeId) {
		return employeeDao.existsById(employeeId);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeDao.deleteEmployee(employeeId);
		
	}

	@Override
	public List<Employee> findEmployeeByName(String name){
		return employeeDao.findEmployeeByName(name);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}

	
	
	


}
