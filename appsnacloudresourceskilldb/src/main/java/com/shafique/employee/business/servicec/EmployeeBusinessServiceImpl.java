package com.shafique.employee.business.servicec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shafique.employee.business.service.data.EmployeeDataService;
import com.shafique.employee.clusters.EmployeeSkillCluster;
import com.shafique.employee.designation.EmployeeSkills;
import com.shafique.model.Employee;

@Component
public class EmployeeBusinessServiceImpl implements EmployeeBusinessService {

	@Autowired
	private EmployeeDataService employeeDataService;

	public Employee insertEmployee(Employee emp) throws Exception {
		emp = addDefaultCluster(emp);
		return employeeDataService.addEmployee(emp);
	}

	public Employee updateEmployee(Employee emp) throws Exception {
		emp = createCluster(emp);
		return employeeDataService.updateEmployee(emp);
	}

	public List<Employee> getEmployees() {
		return employeeDataService.getEmployees();
	}

	public Employee getEmployee(Long id) {
		return employeeDataService.getEmployee(id);
	}

	public List<EmployeeSkills> getTopics(Long empId) {
		return employeeDataService.getEmployee(empId).get_topics();
	}

	public Employee addTopic(Long empId, EmployeeSkills emplSkill) throws Exception {
		Employee empl = employeeDataService.getEmployee(empId);
		List<EmployeeSkills> employeeSkills = empl.get_topics();
		if (employeeSkills == null) {
			List<EmployeeSkills> emplSkills = new ArrayList<EmployeeSkills>();
			emplSkills.add(emplSkill);
			empl.set_topics(employeeSkills);
		} else {
			employeeSkills.add(emplSkill);
			empl.set_topics(employeeSkills);
		}
		empl = employeeDataService.addEmployee(empl);
		return empl;
	}

	public Employee updateTopic(Long empId, int topicIndex, EmployeeSkills emplSkill) throws Exception {
		Employee empl = employeeDataService.getEmployee(empId);
		if(empl.get_topics() != null || !empl.get_topics().isEmpty()) {
			empl.get_topics().remove(topicIndex);
			empl.get_topics().add(topicIndex, emplSkill);			
		}
		empl = createCluster(empl);
		empl =employeeDataService.addEmployee(empl);
		System.out.println(empl);
		return empl;
	}

	private Employee createCluster(Employee empl) throws Exception {
		List<EmployeeSkillCluster<EmployeeSkills>> clusters = empl.get_emplSkillClusters();
		List<EmployeeSkills> topics = empl.get_topics();
		List<EmployeeSkills> _updatedTopics = new ArrayList<EmployeeSkills>();
		for (EmployeeSkills topic : topics) {
			boolean isClusterFound = false;
			if (topic.getClusterLevel() > 3) {
				throw new Exception();
			} else {
				if ("COMPLETE".equals(topic.getStatus())) {
					System.out.println(clusters.get(topic.getClusterLevel() - 1));
					clusters.get(topic.getClusterLevel() - 1).get_clusturTopics().add(topic);
					isClusterFound = true;
				}
			}

			if (!isClusterFound) {
				_updatedTopics.add(topic);
			}

		}

		empl.set_emplSkillClusters(clusters);
		empl.set_topics(_updatedTopics);
		return empl;
	}

	private Employee addDefaultCluster(Employee emp) {
		List<EmployeeSkillCluster<EmployeeSkills>> clusters = emp.get_emplSkillClusters();
		if (clusters.isEmpty()) {
			for (int x = 1; x <= 3; x++) {
				clusters.add(new EmployeeSkillCluster<EmployeeSkills>(x));
			}
		}
		return emp;
	}

}
