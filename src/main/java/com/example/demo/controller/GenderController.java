package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.entity.Gender;
import com.example.demo.repository.GenderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class GenderController {
   
   
@Autowired
private final GenderRepository genderRepository;

public GenderController(GenderRepository genderRepository){
this.genderRepository = genderRepository;
}

@GetMapping("/gender")
public Collection<Gender>  gender(){
    return genderRepository.findAll().stream().collect(Collectors.toList());
}

@GetMapping("/gender/{id}")
public Optional<Gender> gender(@PathVariable Long id) {
    Optional<Gender> gender = genderRepository.findById(id);
    return gender;
}



}
