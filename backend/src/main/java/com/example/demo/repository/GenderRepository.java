package com.example.demo.repository;

import com.example.demo.entity.Gender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource  
public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findById(long id);
}
