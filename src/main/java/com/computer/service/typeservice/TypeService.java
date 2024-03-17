package com.computer.service.typeservice;

import com.computer.model.entity.Type;
import com.computer.repo.type.ITypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepo iTypeRepo;
    @Override
    public Iterable<Type> findAll() {
        return iTypeRepo.findAll();

    }

    @Override
    public Optional<Type> findById(Long id) {
        return iTypeRepo.findById(id);
    }

    @Override
    public Type save(Type type) {
        return iTypeRepo.save(type);
    }

    @Override
    public void remove(Long id) {
        iTypeRepo.setNullAndDeleteTypeById(id);
    }

}
