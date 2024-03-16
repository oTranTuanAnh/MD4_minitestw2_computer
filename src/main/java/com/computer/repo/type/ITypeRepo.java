package com.computer.repo.type;

import com.computer.model.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepo extends CrudRepository<Type, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "call setNullTypeInComputerListAndDelete(:id)")
    void setNullAndDeleteTypeById(@Param("id") Long id);
}
