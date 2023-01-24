package com.ectimel.springbootrestapihibernate.rest;

import com.ectimel.springbootrestapihibernate.entity.Employee;
import com.ectimel.springbootrestapihibernate.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class RController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public String home(){
        return "Hello RestAPI";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
    }

    @PutMapping("/employee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
    }

}
