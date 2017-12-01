package com.shafique.employee.clusters;

import java.util.ArrayList;
import java.util.List;

public  class EmployeeSkillCluster<EmployeeSkills> {
	
	public EmployeeSkillCluster() {
	}
	
	public EmployeeSkillCluster(int level) {
		clusterLevel = level;		
	}
	
	private int clusterLevel;
	
	private String completionStatus = "ASSIGNED";
	
	private List<EmployeeSkills> _clusturTopics = new ArrayList<EmployeeSkills>();

	public List<EmployeeSkills> get_clusturTopics() {
		return _clusturTopics;
	}

	public void set_clusturTopics(List<EmployeeSkills> _clusturTopics) {
		this._clusturTopics = _clusturTopics;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	public int getClusterLevel() {
		return clusterLevel;
	}

	public void setClusturLevel(int clusterLevel) {
		this.clusterLevel = clusterLevel;
	}

	@Override
	public String toString() {
		return "EmployeeSkillCluster [clusterLevel=" + clusterLevel + ", completionStatus=" + completionStatus
				+ ", _clusturTopics=" + _clusturTopics + "]";
	}
	
	
		
}
