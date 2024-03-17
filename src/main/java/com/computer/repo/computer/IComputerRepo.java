package com.computer.repo.computer;

import com.computer.model.entity.Computer;
import org.springframework.data.repository.CrudRepository;

public interface IComputerRepo extends CrudRepository<Computer, Long> {
}
