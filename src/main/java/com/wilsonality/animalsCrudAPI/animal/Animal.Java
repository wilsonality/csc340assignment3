package com.wilsonality.animalscrudapi.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal{
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long animalID;

  @Column(nullable = false)
  private String name;

  private String description;

  private int lifespan;

  private String habitat;

  public Animal(){}

  public Animal(Long animalID, String name, String description, int lifespan, String habitat){
    this.animalID = animalID;
    this.name = name;
    this.description = description;
    this.lifespan = lifespan;
    this.habitat = habitat;
  }

  public Animal(String name, String description, int lifespan, String habitat){
    this.name = name;
    this.description = description;
    this.lifespan = lifespan;
    this.habitat = habitat;
  }

  public Long getAnimalID(){
    return animalID;
  }

  public void setAnimalID(Long nAnimalID){
    this.animalID = nAnimalID;
  }

  public String getName(){
    return name;
  }

  public void setName(String nName){
    this.name = nName;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String nDesc){
    this.description = nDesc;
  }

  public int getLifespan(){
    return lifespan;
  }

  public void setLifespan(int nLifespan){
    this.lifespan = nLifespan;
  }

  public String getHabitat(){
    return habitat;
  }

  public void setHabitat(String nHabitat){
    this.habitat = nHabitat;
  }
}
