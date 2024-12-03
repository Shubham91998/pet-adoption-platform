package dao;

import model.Pet;
import java.util.List;

public interface PetDAO {
    void addPet(Pet pet);
    Pet getPetById(int petId);
    List<Pet> getAllPets();
    void updatePet(Pet pet);
    void deletePet(int petId);
}