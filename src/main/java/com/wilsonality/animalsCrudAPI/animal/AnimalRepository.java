package com.wilsonality.animalscrudapi.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query
    List<Animal> getAnimalsByHabitatContainingIgnoreCase(String habitat);

    // @Query(value = "select * from animals a where a.name= ?1", nativeQuery= = true)
    List<Animal> getAnimalsByNameContainingIgnoreCase(String name);

    @Query(value = "select * from animals a where a.habitat='ocean'", nativeQuery = true)
    List<Animal> getMarineAnimals();

}
