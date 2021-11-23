package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  
@Data  
@NoArgsConstructor  
@Table(name = "GENDER")
public class Gender {
    
    @Id 
    @SequenceGenerator(name="GENDER_seq",sequenceName="GENDER_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GENDER_seq") 
    @Column(name = "GENDER_ID", unique = true, nullable = true)
    private Long id;  
  
  
    @Getter @Setter
    private String name = "";


    @OneToMany(fetch = FetchType.LAZY)
    //mappedBy  = "type"
    private Collection<Pet> pet;
}
