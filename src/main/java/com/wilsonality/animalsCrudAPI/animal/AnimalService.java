package com.wilsonality.animalscrudapi.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AnimalService{

    @Autowired
    private AnimalRepository animalRepository;

    /**
    * Method to get all animals
    *
    * @return List of all animals
    */
    public Object getAllAnimals() {
        return animalRepository.findAll();
    }

    /** Method to get animal by ID
     * 
     * @param animalID the ID of the animal to search for
     * @return the animal with the specified ID
        
    } */

    public Animal getAnimalbyID(@PathVariable long animalID){
        return animalRepository.findById(animalID).orElse(null);
    }

    /** Method to get animals with names containing a string
     * 
     * @param name the name to search for
     * @return the animals containing the specified name
        
    } */
    public List<Animal> getAnimalsbyName(String name){
        return animalRepository.getAnimalsbyNameContainingIgnoreCase(name);
    }

    /** Method to get animals by habitat
     * 
     * @param habitat the habitat to search for
     * @return the animals with the specified habitat
     */
    public List<Animal> getAnimalsbyHabitat(String habitat){
        return animalRepository.getAnimalsbyHabitatContainingIgnoreCase(habitat);
    }

    /**
    * Fetch all marine animals
    *
    * @return the list of sea (marine)animals
    */
    public Object getSeaAnimals(){
        return animalRepository.getSeaAnimals();
    }

    /** Method to add a new animal
     * 
     * @param animal the new animal to add
        
    } */

    public Animal addAnimal(Animal animal){
        return animalRepository.save(animal);
    }




}