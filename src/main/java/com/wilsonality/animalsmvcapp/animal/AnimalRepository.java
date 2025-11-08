package com.wilsonality.animalsmvcapp.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query
    List<Animal> findByHabitatContainingIgnoreCase(String habitat);

    // @Query(value = "select * from animals a where a.name= ?1", nativeQuery= = true)
    List<Animal> findByNameContainingIgnoreCase(String name);

    @Query(value = "select * from animals a where a.habitat='ocean'", nativeQuery = true)
    List<Animal> getMarineAnimals();

}
