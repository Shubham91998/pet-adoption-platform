import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dao.PetDAOImpl;
import model.Pet;
import java.util.List;

class PetDAOTest {

    PetDAOImpl petDAO = new PetDAOImpl();

    @Test
    void getPetById_validId_shouldReturnPet() {
        Pet pet = petDAO.getPetById(1);
        assertNotNull(pet, "Pet should not be null for a valid ID");
    }

    @Test
    void getAllPets_shouldReturnNonEmptyList() {
        List<Pet> pets = petDAO.getAllPets();
        assertTrue(pets.size() > 0, "Pets list should not be empty");
    }

    @Test
    void deletePet_invalidId_shouldReturnFalse() {
        boolean status = petDAO.deletePet(2);
        assertFalse(status, "Deleting a non-existing pet should return false");
    }
}
