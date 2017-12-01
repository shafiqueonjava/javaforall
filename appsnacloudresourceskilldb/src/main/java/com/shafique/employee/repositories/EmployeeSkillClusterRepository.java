package com.shafique.employee.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shafique.employee.clusters.EmployeeSkillCluster;
import com.shafique.employee.designation.EmployeeSkills;

public interface EmployeeSkillClusterRepository extends MongoRepository<EmployeeSkillCluster<EmployeeSkills>, Long> {

}
