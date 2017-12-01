package com.shafique.employee.business.service.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shafique.employee.clusters.EmployeeSkillCluster;
import com.shafique.employee.designation.EmployeeSkills;
import com.shafique.model.Employee;

@Repository
public interface EmployeeDataService {

	public Employee addEmployee(Employee emp);
	
	public Employee updateEmployee(Employee emp);
	
	public List<Employee> getEmployees();
	
	public Employee searchEmployeeById(Long id);
	
	
	public List<EmployeeSkillCluster<EmployeeSkills>> getEmployeeCluster(Long empId);			
	
	public Employee getEmployee(Long id);
	
	
	
	
}
