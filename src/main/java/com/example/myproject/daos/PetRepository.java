package com.example.myproject.daos;

import com.example.myproject.daos.dtos.PetNameAndBreed;
import com.example.myproject.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    Pet updatePetById(Pet pet);
    void deletePetsByName(String name);
    Optional<Pet> findPetsByAnimalType(String animalType);
    Optional<Pet> findPetsByBreed(String breed);

    @Query("SELECT new com.example.myproject.daos.dtos.PetNameAndBreed(p.name, p.animalType, p.breed) FROM Pet p")
    Optional<PetNameAndBreed> findPetNameAndBreed();

    @Modifying
    @Transactional
    @Query(value = "UPDATE pets SET name=:newName WHERE pet_id=:id",
            nativeQuery = true)
    void updatePetById(@Param("id") int id, @Param("newName") String newName);
}
