package com.computer.controller;


import com.computer.model.entity.Computer;
import com.computer.model.entity.Type;
import com.computer.service.computerservice.ComputerService;
import com.computer.service.typeservice.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@Controller
@RequestMapping("/computers")
public class ComputerController {


    @Autowired
    private ComputerService computerService;

    @Autowired
    private TypeService typeService;

    @GetMapping()
    public String findAllComputer(Model model) {
        model.addAttribute("computers", computerService.findAll());
        return "computer/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("computer", new Computer());
        return "computer/create";
    }

    @ModelAttribute("types")
    public Iterable<Type> listType() {
        return typeService.findAll();
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("computer") Computer computer) {
        computerService.save(computer);
        return "redirect:/computers";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<Computer> computer = computerService.findById(id);
        model.addAttribute("computer", computer.get());
        return "computer/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("computer") Computer computer) {
        computerService.save(computer);
        return "redirect:/computers";
    }
        @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        computerService.remove(id);
        return "redirect:/computers";
    }

}



