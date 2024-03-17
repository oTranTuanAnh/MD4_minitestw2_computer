package com.computer.service.typeservice;

import com.computer.model.entity.Type;
import com.computer.repo.type.ITypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeService implements ITypeService{

    @Autowired
    public ITypeRepo typeRepo;


    @Override
    public Iterable<Type> findAll() {
        return typeRepo.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Type save(Type type) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
