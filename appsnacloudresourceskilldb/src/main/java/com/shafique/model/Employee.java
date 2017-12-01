package com.shafique.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shafique.employee.clusters.EmployeeSkillCluster;
import com.shafique.employee.designation.EmployeeSkills;

@Document
public class Employee {

	@Id	
	private long employeeId;
	
	private String _empl_firstName;
	
	private String _empl_middleName;
	
	private String _empl_lastName;
	
	private String _empl_designation;
	
	private List<EmployeeSkills> _topics;	
	
	private List<EmployeeSkillCluster<EmployeeSkills>> _emplSkillClusters = new ArrayList<EmployeeSkillCluster<EmployeeSkills>>();
		
		
	public List<EmployeeSkills> get_topics() {
		return _topics;
	}

	public void set_topics(List<EmployeeSkills> _topics) {
		this._topics = _topics;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String get_empl_firstName() {
		return _empl_firstName;
	}

	public void set_empl_firstName(String _empl_firstName) {
		this._empl_firstName = _empl_firstName;
	}

	public String get_empl_middleName() {
		return _empl_middleName;
	}

	public void set_empl_middleName(String _empl_middleName) {
		this._empl_middleName = _empl_middleName;
	}

	public String get_empl_lastName() {
		return _empl_lastName;
	}

	public void set_empl_lastName(String _empl_lastName) {
		this._empl_lastName = _empl_lastName;
	}

	public String get_empl_designation() {
		return _empl_designation;
	}

	public void set_empl_designation(String _empl_designation) {
		this._empl_designation = _empl_designation;
	}

	public List<EmployeeSkillCluster<EmployeeSkills>> get_emplSkillClusters() {
		return _emplSkillClusters;
	}

	public void set_emplSkillClusters(List<EmployeeSkillCluster<EmployeeSkills>> _emplClusters) {
		this._emplSkillClusters = _emplClusters;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", _empl_firstName=" + _empl_firstName + ", _empl_middleName="
				+ _empl_middleName + ", _empl_lastName=" + _empl_lastName + ", _empl_designation=" + _empl_designation
				+ ", _topics=" + _topics + ", _emplSkillClusters=" + _emplSkillClusters + "]";
	}
	
	
	
}
