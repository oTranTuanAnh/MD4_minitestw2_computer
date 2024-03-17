package com.computer.controller;

import com.computer.service.computerservice.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComputerController {
    @Autowired
    private ComputerService computerService;
//    @GetMapping("/admin")
//    public ModelAndView admin(){
//        return new ModelAndView("admin");
//    }
    @GetMapping("/admin")
    public ModelAndView showListComputer(){
        ModelAndView modelAndView = new ModelAndView("computerviews");
        modelAndView.addObject("computer", computerService.findAll());
        return modelAndView;
    }

}
