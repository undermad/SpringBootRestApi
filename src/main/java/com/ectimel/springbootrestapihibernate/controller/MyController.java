package com.ectimel.springbootrestapihibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MyController {

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("theDate", new Date());

        return "home";
    }
}
