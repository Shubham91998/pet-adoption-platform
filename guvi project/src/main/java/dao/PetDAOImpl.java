package dao;

import model.Pet;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {

    private Connection connection;

    public PetDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, species, breed, age, gender, adoption_status, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, pet.getName());
            pstmt.setString(2, pet.getSpecies());
            pstmt.setString(3, pet.getBreed());
            pstmt.setInt(4, pet.getAge());
            pstmt.setString(5, pet.getGender());
            pstmt.setString(6, pet.getAdoptionStatus());
            pstmt.setString(7, pet.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pet getPetById(int petId) {
        Pet pet = null;
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, petId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pet = new Pet();
                pet.setPetId(rs.getInt("pet_id"));
                pet.setName(rs.getString("name"));
                pet.setSpecies(rs.getString("species"));
                pet.setBreed(rs.getString("breed"));
                pet.setAge(rs.getInt("age"));
                pet.setGender(rs.getString("gender"));
                pet.setAdoptionStatus(rs.getString("adoption_status"));
                pet.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("pet_id"));
                pet.setName(rs.getString("name"));
                pet.setSpecies(rs.getString("species"));
                pet.setBreed(rs.getString("breed"));
                pet.setAge(rs.getInt("age"));
                pet.setGender(rs.getString("gender"));
                pet.setAdoptionStatus(rs.getString("adoption_status"));
                pet.setDescription(rs.getString("description"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public void updatePet(Pet pet) {
        String sql = "UPDATE pets SET name = ?, species = ?, breed = ?, age = ?, gender = ?, adoption_status = ?, description = ? WHERE pet_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, pet.getName());
            pstmt.setString(2, pet.getSpecies());
            pstmt.setString(3, pet.getBreed());
            pstmt.setInt(4, pet.getAge());
            pstmt.setString(5, pet.getGender());
            pstmt.setString(6, pet.getAdoptionStatus());
            pstmt.setString(7, pet.getDescription());
            pstmt.setInt(8, pet.getPetId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePet(int petId) {
        String sql = "DELETE FROM pets WHERE pet_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, petId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
