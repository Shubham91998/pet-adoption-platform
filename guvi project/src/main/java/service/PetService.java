// src/main/java/service/PetService.java
package service;

import dao.PetDAO;
import dao.PetDAOImpl;
import model.Pet;
import java.util.List;

public class PetService {

    private PetDAO petDAO;

    public PetService() {
        petDAO = new PetDAOImpl();
    }

    public void addPet(Pet pet) {
        petDAO.addPet(pet);
    }

    public Pet getPetById(int petId) {
        return petDAO.getPetById(petId);
    }

    public List<Pet> getAllPets() {
        return petDAO.getAllPets();
    }

    public void updatePet(Pet pet) {
        petDAO.updatePet(pet);
    }

    public void deletePet(int petId) {
        petDAO.deletePet(petId);
    }
}
