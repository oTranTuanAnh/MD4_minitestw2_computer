package com.computer.service.computerservice;

import com.computer.model.entity.Computer;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ComputerService implements IComputerService{
    @Override
    public Iterable<Computer> findAll() {
        return null;
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Computer save(Computer computer) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
