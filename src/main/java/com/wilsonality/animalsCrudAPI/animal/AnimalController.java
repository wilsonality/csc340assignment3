
package com.wilsonality.animalscrudapi.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService; 

    /**
     * Endpoint to get all animals
     * @return list of all animals
     */
    @GetMapping("/animals")
    public Object getAllAnimals(){
        return animalService.getAllAnimals();
    }

    /**
     * Endpoint to get an animal by id
     * @param animalID 
     * @return the animal with the special ID
     */

     @GetMapping("/animals/{animalID}")
     public Object getAnimalsbyID(@PathVariable long animalID){
        return animalService.getAnimalbyID(animalID);
     }

     /**
      * Endpoint to get animals by name
      * @param name name to search for
      * @return animals with matching names, or all animals if none
      */
     @GetMapping("/animals/name")
     public Object getAnimalbyName(@RequestParam String key){
        if (key != null){
            return animalService.getAnimalsbyName(key);
        }
        else{
            return animalService.getAllAnimals();
        }
     }
     
    /** Endpoint to get animals by habitat
     * @param habitat habitat to search for animals in
     * @return animals with matching habitat
     */
    @GetMapping("/animals/habitat/{habitat}")
    public Object getAnimalsbyHabitat(@RequestParam String habitat){
        return animalService.getAnimalsbyHabitat(habitat);
    }

    /** Endpoint to get marine animals
     * @return animals in marine habitats
     */
    @GetMapping("/animals/habitat/marine")
    public Object getMarineAnimals(){
        return animalService.getMarineAnimals();
    }

    /** Endpoint to add an animal
     * @param animal the animal to add
     * @return display all animals
     */
    @PostMapping("/animals")
    public Object addAnimal(@RequestBody Animal animal){
        return animalService.addAnimal(animal);
    }

    /** Endpoint to edit an animal
     * @param animalID id of the animal to edit
     * @param animal the updated animal
     * @return display the changes
     */
    @PutMapping("/animals/{animalID}")
    public Object updateAnimal(@PathVariable long animalID, @RequestBody Animal animal){
        animalService.updateAnimal(animalID, animal);
        return animalService.getAnimalbyID(animalID);
    }

    /**Endpoint to delete an animal
     * @param animalID
     * @return display all animals
     */
    @DeleteMapping("/animals/{animalID}")
    public Object deleteAnimal(@PathVariable long animalID){
        animalService.deleteAnimal(animalID);
        return animalService.getAllAnimals();
    }

    /** Endpoint to write animal to a JSON file
     * @param animal the animal object ot write
     * @return string to report success
     */
    @PostMapping("/animals/writeFile")
    public String writeJSON(@RequestBody Animal animal){
        return animalService.writeJSON(animal);
    }

    /**
     * Endpoint to read animal from a JSON file
     * @return content of JSON file
     */
    @GetMapping("/animals/readFile")
    public Object readJSON(){
        return animalService.readJSON();
    }

}