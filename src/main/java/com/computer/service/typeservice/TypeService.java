package com.computer.service.typeservice;

import com.computer.model.entity.Type;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeService implements ITypeService{
    @Override
    public Iterable<Type> findAll() {
        return null;
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
