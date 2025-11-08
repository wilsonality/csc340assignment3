package com.wilsonality.animalsmvcapp.animal;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AnimalService{

    @Autowired
    private AnimalRepository animalRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/animal-pictures/";

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
    public Object getAnimalsbyName(String name){
        return animalRepository.findByNameContainingIgnoreCase(name);
    }


    /** Method to get animals by habitat
     * 
     * @param habitat the habitat to search for
     * @return the animals with the specified habitat
     */
    public Object getAnimalsbyHabitat(String habitat){
        return animalRepository.findByHabitatContainingIgnoreCase(habitat);
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
    * @param animalPicture the picture of the animal to add
    */
    public Animal addAnimal(Animal animal, MultipartFile animalPic){
        Animal nAnimal = animalRepository.save(animal);
        String ogFileName = animalPic.getOriginalFilename();

        try {
            // validate the file name
            if (ogFileName != null && ogFileName.contains(".")){
                String fileExtension = ogFileName.substring(ogFileName.lastIndexOf("." + 1));
                String fileName = String.valueOf(nAnimal.getAnimalID())  + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = animalPic.getInputStream();
                Files.deleteIfExists(filePath);
                // save animalpic to location at file path, replacing an existing file
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                animal.setAnimalPicturePath(fileName);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return animalRepository.save(animal);
    }
    /**
     * Method to update a animal, accessed by its ID
     * @param animalID the id of the animal to be updated
     * @param animal the updated animal
     */
    public Animal updateAnimal(Long animalID, Animal animal, MultipartFile animalPic){
        String ogFileName = animalPic.getOriginalFilename();

        try {
            // validate the file name
            if (ogFileName != null && ogFileName.contains(".")){
                String fileExtension = ogFileName.substring(ogFileName.lastIndexOf("." + 1));
                String fileName = String.valueOf(animalID)  + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = animalPic.getInputStream();
                Files.deleteIfExists(filePath);
                // save animalpic to location at file path, replacing an existing file
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                animal.setAnimalPicturePath(fileName);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
    // public String writeJSON(Animal animal){
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     try{
    //         objectMapper.writeValue(new File("animals.json"), animal);
    //         return "Animal written successfully to JSON";
    //     }
    //     catch(IOException e) {
    //         e.printStackTrace();
    //         return "Error occurred writing animal to JSON file.";
    //     }
    // }

    /**
     * Method to read an animal from JSON file
     * @return content of JSON file
     */

    //  public Object readJSON(){
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     try{
    //         return objectMapper.readValue((new File("animals.json")), Animal.class);
    //     }
    //     catch(IOException e){
    //         e.printStackTrace();
    //         return null;
    //     }
    //  }



}