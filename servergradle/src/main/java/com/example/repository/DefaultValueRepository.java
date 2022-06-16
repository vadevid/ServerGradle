package com.example.repository;

import com.example.entity.DefaultValue;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
@Repository
public interface DefaultValueRepository extends CrudRepository<DefaultValue, Integer> {
    DefaultValue getById(Integer id);

}
