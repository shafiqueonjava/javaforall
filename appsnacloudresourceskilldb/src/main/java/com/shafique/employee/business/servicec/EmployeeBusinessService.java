package com.shafique.employee.business.servicec;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shafique.employee.clusters.EmployeeSkillCluster;
import com.shafique.employee.designation.EmployeeSkills;
import com.shafique.model.Employee;

@Service
public interface EmployeeBusinessService {
	
	public Employee insertEmployee(Employee emp) throws Exception;
	
	public Employee updateEmployee(Employee emp)  throws Exception ;
	
	public List<Employee> getEmployees();

	public Employee getEmployee(Long id);
	
	public List<EmployeeSkills> getTopics(Long empId);
	
	public Employee addTopic(Long empId, EmployeeSkills emplSkill) throws Exception;
		
	
	
	
}
