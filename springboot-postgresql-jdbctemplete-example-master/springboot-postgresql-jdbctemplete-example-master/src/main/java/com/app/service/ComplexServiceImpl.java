package com.app.service;

import com.app.dao.ComplexDao;

import com.app.model.Complex;
import com.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplexServiceImpl implements ComplexService {
	@Autowired
	private ComplexDao complexDao;

	public void saveEmployee(Employee employee) {
		complexDao.addEmployee(employee);
		
	}

	@Override
	public List<Employee> findEmployeeByName(String name){
		return complexDao.findEmployeeByName(name);
	}

	@Override
	public List<Employee> findEmployeecontainName(String name,String tt){
		return complexDao.findEmployeecontainName(name,tt);
	}

	public List<Employee> getAllEmployees() {
		
		return complexDao.getEmployees();
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee=complexDao.findEmployeeById(employeeId);
		return employee;
	}

	@Override
	public boolean isExsits(Integer employeeId) {
		return complexDao.existsById(employeeId);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		complexDao.deleteEmployee(employeeId);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		complexDao.updateEmployee(employee);
		
	}

	
	
	


}
