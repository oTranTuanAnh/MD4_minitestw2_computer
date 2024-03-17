package com.computer.controller;

import com.computer.model.entity.Computer;
import com.computer.model.entity.Type;
import com.computer.service.typeservice.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping()
    public String findAllComputer(Model model) {
        model.addAttribute("types", typeService.findAll());
        return "type/index";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("type", new Type());
        return "types/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("type") Type type) {
        typeService.save(type);
        return "redirect:/types";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<Type> type = typeService.findById(id);
        model.addAttribute("type", type.get());
        return "types/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("type") Type type) {
        typeService.save(type);
        return "redirect:/types";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        typeService.remove(id);
        return "redirect:/types";
    }

}
