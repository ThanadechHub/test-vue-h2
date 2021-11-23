package com.example.demo.controller;

import java.net.URLDecoder;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.entity.Gender;
import com.example.demo.entity.Pet;
import com.example.demo.repository.GenderRepository;
import com.example.demo.repository.PetRepository;

import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(origins = "http://localhost:8080")
@NoArgsConstructor
@RestController
public class PetController {
    @Autowired
    private  PetRepository petRepository;
    @Autowired
    private GenderRepository genderRepository;

    PetController (PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @GetMapping("/pet")
    public Collection<Pet> Pets(){ 
        return petRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/pet/{id}")
    public Optional<Pet> Pets(@PathVariable Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet;
    }

    @PutMapping("/pet/{id}")
    Pet newPet(@PathVariable Long id, @RequestBody Map<String, String> body){

        Pet oldData = petRepository.findById(id).orElse(null); 
        Gender Gender = genderRepository.findById(Long.valueOf(body.get("gender")).longValue());
      
        oldData.setName(body.get("name"));
        oldData.setAge(Integer.valueOf(body.get("age").toString()));
        oldData.setGender(Gender);

        return petRepository.save(oldData);
    }

    @RequestMapping(value = "/petPost",method = RequestMethod.POST)
    public Pet newPet(@RequestBody Map<String, String> body) {
        
        Pet pet = new Pet();
        Gender Gender = genderRepository.findById(Long.valueOf(body.get("gender")).longValue());
                pet.setName(body.get("name"));
                pet.setAge(Integer.valueOf(body.get("age").toString()));
                pet.setGender(Gender);

        return petRepository.save(pet) ;
    }
    
	@DeleteMapping("/pet/{id}")
	public ResponseEntity<HttpStatus> deletePet(@PathVariable("id") long id) {
		try {
			petRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @DeleteMapping("/pet")
	public ResponseEntity<HttpStatus> deletePets() {
		try {
			petRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
