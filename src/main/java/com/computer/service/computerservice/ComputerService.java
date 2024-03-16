package com.computer.service.computerservice;

import com.computer.model.entity.Computer;
import com.computer.repo.computer.IComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ComputerService implements IComputerService{
    @Autowired
    private IComputerRepo computerRepo;

    @Override
    public Iterable<Computer> findAll() {
        return computerRepo.findAll();
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return computerRepo.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return computerRepo.save(computer);
    }

    @Override
    public void remove(Long id) {
        computerRepo.deleteById(id);
    }
}
