package com.shafique.employee.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shafique.model.Employee;

public interface EmployeeRepositories extends MongoRepository<Employee, String> {

	public Employee findByEmployeeId(Long employeeId);
}
