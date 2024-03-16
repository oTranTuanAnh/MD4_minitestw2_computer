package com.computer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComputerController {
    @GetMapping("/home")
    public String showHomePage(){
        return "index";
    }

}
