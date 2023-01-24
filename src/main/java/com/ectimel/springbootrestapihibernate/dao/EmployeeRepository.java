package com.ectimel.springbootrestapihibernate.dao;

import com.ectimel.springbootrestapihibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
