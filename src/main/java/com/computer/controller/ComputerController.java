package com.computer.controller;

import com.computer.model.entity.Computer;
import com.computer.service.computerservice.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/api/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping()
    public ResponseEntity<Iterable<Computer>> findAllComputer() {
        Iterable<Computer> computers = computerService.findAll();
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> findComputerById (@PathVariable Long id) {
        Optional<Computer> customer = computerService.findById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Computer> saveComputer(@RequestBody Computer customer) {
        return new ResponseEntity<>(computerService.save(customer),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable Long id, @RequestBody Computer computer) {
        Optional<Computer> optionalComputer = computerService.findById(id);
        if (!optionalComputer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computer.setId(optionalComputer.get().getId());
        return new ResponseEntity<>(computerService.save(computer),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteCustomer(@PathVariable Long id) {
        Optional<Computer> computerOptional = computerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computerService.remove(id);
        return new ResponseEntity<>(computerOptional.get(),HttpStatus.OK);
    }
}
