package com.shafique.employee.business.service.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shafique.employee.clusters.EmployeeSkillCluster;
import com.shafique.employee.designation.EmployeeSkills;
import com.shafique.employee.repositories.EmployeeRepositories;
import com.shafique.model.Employee;

@Component
public class EmployeeDataServiceImpl implements EmployeeDataService {

	@Autowired
	private EmployeeRepositories employeeRepository;

	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	public Employee updateEmployee(Employee emp) {		
		return employeeRepository.save(emp);
	}

	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}

	public Employee searchEmployeeById(Long id) {
		return employeeRepository.findByEmployeeId(id);
	}

	public List<EmployeeSkillCluster<EmployeeSkills>> getEmployeeCluster(Long empId) {
		return employeeRepository.findByEmployeeId(empId).get_emplSkillClusters();
	}

	public Employee getEmployee(Long id) {
		return employeeRepository.findByEmployeeId(id);
	}

}
