package com.shafique.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shafique.employee.business.servicec.EmployeeBusinessService;
import com.shafique.employee.clusters.EmployeeSkillCluster;
import com.shafique.employee.designation.EmployeeSkills;
import com.shafique.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeBusinessService employeeBusinessService;
	
	// add an employee
	@RequestMapping(path= {"/insertemployee"}, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee insertEmployee(@RequestBody Employee emp) throws Exception {
		return employeeBusinessService.insertEmployee(emp);
	}
	
	//update employee
	@RequestMapping(path= {"/{empId}"}, method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody Employee empl) throws Exception {
		return employeeBusinessService.updateEmployee(empl);
	}
	
	// list all employees
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getmployees() {
		return employeeBusinessService.getEmployees();		
	}
	
	// get a particular employee
	@RequestMapping(path= {"/{empId}"},method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable("empId") Long empId) {
		return employeeBusinessService.getEmployee(empId);
	}

	// list all topics for an employee
	@RequestMapping(path= {"/{empId}/topics"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeSkills> getTopics(@PathVariable("empId") Long empId){
		return employeeBusinessService.getTopics(empId);
	}
	
	//add new topic for an employee
	@RequestMapping(path= {"/{empId}/topics"}, method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee addTopic(@PathVariable("empId") Long empId, @RequestBody EmployeeSkills emplTopic) throws Exception {
		return employeeBusinessService.addTopic(empId, emplTopic);
	}
	
	//update topic
	@RequestMapping(path= {"/{empId}/topics/{topicIndex}"}, method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee updateTopic(@PathVariable("empId") Long empId, @PathVariable("topicIndex") int topicIndex, @RequestBody EmployeeSkills emplTopic) throws Exception {
		return employeeBusinessService.updateTopic(empId, topicIndex, emplTopic);
	}
	
	
	
	
	
	
}
