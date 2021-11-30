package com.example.demo;

import java.util.stream.Stream;

import com.example.demo.entity.Gender;
import com.example.demo.repository.GenderRepository;
import com.example.demo.repository.PetRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PetRepository petRepository
						   ,GenderRepository genderRepository){

		return args -> {

			Gender gender1 = new Gender();
			gender1.setName("ชาย");
			genderRepository.save(gender1);

			Gender gender2 = new Gender();
			gender2.setName("หญิง");
			genderRepository.save(gender2);

			// Stream.of("ชาย", "หญิง").forEach(name -> {
			// 	Gender gender = new Gender();
			// 	gender.setName(name);
			// 	genderRepository.save(gender);
			// });

		};
	}

}
