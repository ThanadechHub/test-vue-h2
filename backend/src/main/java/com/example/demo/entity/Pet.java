package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PET")
public class Pet {
    
    @Id
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "PET_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @Column(name = "PET_ID", unique = true, nullable = true)
    private Long id;
    
    @Getter@Setter
    private String name;

    @Getter@Setter
    private int age;

    @Override
    public String toString() {
      return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }



  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
  @JoinColumn(name = "GENDER_ID", insertable = true)
  private Gender gender;

}
