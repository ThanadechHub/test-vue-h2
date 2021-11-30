package com.example.demo.repository;

import com.example.demo.entity.Pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findById(long id);
}

