package com.wilsonality.animalscrudapi.animal;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        return animalRepository.getAnimalsByNameContainingIgnoreCase(name);
    }


    /** Method to get animals by habitat
     * 
     * @param habitat the habitat to search for
     * @return the animals with the specified habitat
     */
    public List<Animal> getAnimalsbyHabitat(String habitat){
        return animalRepository.getAnimalsByHabitatContainingIgnoreCase(habitat);
    }

    /**
     * Fetch all marine animals
     *
     * @return the list of sea (marine)animals
     */
    public Object getMarineAnimals(){
        return animalRepository.getMarineAnimals();
    }

    /** Method to add a new animal
    * 
    * @param animal the new animal to add
    */
    public Animal addAnimal(Animal animal){
        return animalRepository.save(animal);
    }
    /**
     * Method to update a animal, accessed by its ID
     * @param animalID the id of the animal to be updated
     * @param animal the updated animal
     */
    public Animal updateAnimal(Long animalID, Animal animal){
        return animalRepository.save(animal);
    }

    /**
     * Method to delete an animal
     * @param animalID the id of the animal to be deleted
     */
    public void deleteAnimal(Long animalID){
        animalRepository.deleteById(animalID);
    }

    /**
     * Method to write an animal object to a JSON file
     * @param animal the animal object to write
     * @return report success or failure
     */
    public String writeJSON(Animal animal){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("animals.json"), animal);
            return "Animal written successfully to JSON";
        }
        catch(IOException e) {
            e.printStackTrace();
            return "Error occurred writing animal to JSON file.";
        }
    }

    /**
     * Method to read an animal from JSON file
     * @return content of JSON file
     */

     public Object readJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue((new File("animals.json")), Animal.class);
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
     }



}