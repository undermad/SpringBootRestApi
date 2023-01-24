package com.ectimel.springbootrestapihibernate.service;

import com.ectimel.springbootrestapihibernate.dao.EmployeeRepository;
import com.ectimel.springbootrestapihibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Cant find employee with id " + id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepository.save(employee);

        return employee;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
