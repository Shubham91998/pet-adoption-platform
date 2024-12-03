
import model.Pet;
import service.PetService;

public class App {
    public static void main(String[] args) {
        PetService petService = new PetService();
        
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setSpecies("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(3);
        pet.setGender("Male");
        pet.setAdoptionStatus("Available");
        pet.setDescription("Friendly and energetic");

        petService.addPet(pet);

        System.out.println("Pet added successfully!");
    }
}
