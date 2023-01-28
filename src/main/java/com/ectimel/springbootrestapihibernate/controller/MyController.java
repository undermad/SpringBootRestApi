package com.ectimel.springbootrestapihibernate.controller;

import com.ectimel.springbootrestapihibernate.dao.EmployeeRepository;
import com.ectimel.springbootrestapihibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MyController {

    private final EmployeeRepository employeeRepository;

    public MyController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("theDate", new Date());

        return "home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> employeeList = employeeRepository.findAllByOrderByLastNameAsc();

        model.addAttribute("employees", employeeList);

        return "list";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "show-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/showFormUpdate")
    public String update(@RequestParam("employeeId") int id, Model model) {

        model.addAttribute("employee", employeeRepository.findById(id).orElse(null));
        return "show-form-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeRepository.deleteById(id);
        return "redirect:/list";
    }


}
