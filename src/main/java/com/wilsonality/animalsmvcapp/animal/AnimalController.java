package com.wilsonality.animalsmvcapp.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService; 

    /**
     * Endpoint to get all animals
     * @param model The model to add attributes to
     * @return list of all animals
     * 
     */
    @GetMapping({"/animals", "/animals/"})
    public Object getAllAnimals(Model model){
        model.addAttribute("animalslist", animalService.getAllAnimals());
        model.addAttribute("title", "All Animals");
        
        return "animals-list"; // view name
    }

    /**
     * Endpoint to get an animal by id
     * @param animalID id of the specific animal
     * @param model The model to add attributes to
     * @return the animal with the special ID
     */

     @GetMapping("/animals/{animalID}")
     public Object getAnimalsbyID(@PathVariable long animalID, Model model){
        // return animalService.getAnimalbyID(animalID);
        model.addAttribute("animal", animalService.getAnimalbyID(animalID));
        model.addAttribute("title", "Animal #: " + animalID);
        return "animals-details";
     }

     /**
      * Endpoint to get animals by name
      * @param name animal name to search for
      * @param model The model to add attributes to
      * @return animals with matching names, or all animals if none
      */
     @GetMapping("/animals/name")
     public Object getAnimalbyName(@PathVariable String name, Model model){
        if (name != null){
            model.addAttribute("animal", animalService.getAnimalsbyName(name));
            model.addAttribute("title", ("Search for \"" + name + "\""));
            // title of page will be "Search for 'NAME'"
            return "animals-list";
        }
        else{
            return "redirect:/animals/";
        }
     }
     
    /** Endpoint to get animals by habitat
     * @param habitat habitat to search for animals in
     * @param model The model to add attributes to
     * @return animals with matching habitat
     */
    @GetMapping("/animals/habitat/{habitat}")
    public Object getAnimalsbyHabitat(@PathVariable String habitat, Model model){
        model.addAttribute("animalslist", animalService.getAnimalsbyHabitat(habitat));
        model.addAttribute("title", "Search Animals by Habitat");
        return "animals-list";
    }

    /** Endpoint to get marine animals
     * @param model The model to add attributes to
     * @return animals in marine habitats
     */
    @GetMapping("/animals/habitat/marine")
    public Object getMarineAnimals(Model model){
        // return animalService.getMarineAnimals();
        model.addAttribute("animalslist", animalService.getMarineAnimals());
        model.addAttribute("title", "Marine Animals");
        return "animals-list";
    }

    /** Endpoint to show the create form for an animal
     * 
     * @param model The model to add attributes to
     * @return
     */
    @GetMapping("/animals/createForm")
    public Object showCreateForm(Model model){
        Animal nAnimal = new Animal();
        model.addAttribute("animal", nAnimal);
        model.addAttribute("title", "Create New Animal");
        return "animals-create";
    }

    /** Endpoint to add an animal
     * @param animal the animal to add
     * @param picture the picture for the new animal
     * @return display all animals
     */
    @PostMapping("/animals")
    public Object addAnimal(Animal animal,  @RequestParam MultipartFile picture){
        Animal nAnimal = animalService.addAnimal(animal, picture);
        return "redirect:/animals/" + nAnimal.getAnimalID();
    }

    /** Endpoint to show the update form for an animal
     * 
     * @param model The model to add attributes to
     * @return
     */
    @GetMapping("/animals/updateForm/{animalID}")
    public Object showUpdateForm(Model model){
        Animal nAnimal = new Animal();
        model.addAttribute("animal", nAnimal);
        model.addAttribute("title", "Create New Animal");
        return "animals-update";
    }

    /** Endpoint to edit an animal
     * @param animalID id of the animal to edit
     * @param animal the updated animal
     * @param picture the picture of the updated animal
     * @return display the changes
     */
    @PostMapping("/animals/update/{animalID}")
    public Object updateAnimal(@PathVariable long animalID, Animal animal, @RequestParam MultipartFile animalPic, Model model){
        animalService.updateAnimal(animalID, animal, animalPic);
        return "redirect:/animals/" + animalID;
    }

    /**Endpoint to delete an animal
     * @param animalID
     * @return display all animals
     */
    @GetMapping("/animals/delete/{animalID}")
    public Object deleteAnimal(@PathVariable long animalID){
        animalService.deleteAnimal(animalID);
        return "redirect:/animals";
    }

    /** endpoint to write animal to a JSON file
     * @param animal the animal object ot write
     * @return string to report success
     */
    // @PostMapping("/animals/writeFile")
    // public String writeJSON(@RequestParam Animal animal){
    //     return animalService.writeJSON(animal);
    // }

    /**
     * endpoint to read animal from a JSON file
     * @return content of JSON file
     */
    // @GetMapping("/animals/readFile")
    // public Object readJSON(){
    //     return animalService.readJSON();
    // }

}