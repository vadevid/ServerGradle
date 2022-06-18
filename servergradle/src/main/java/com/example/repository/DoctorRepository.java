package com.example.repository;

import com.example.entity.Doctor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    Doctor getById(Integer id);
}
