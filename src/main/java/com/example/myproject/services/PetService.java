package com.example.myproject.services;

import com.example.myproject.daos.dtos.PetNameAndBreed;
import com.example.myproject.entities.Pet;
import com.example.myproject.services.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface PetService {
    Pet CreatePet(Pet pet);
    List<Pet> GetAllPets();
    Pet GetPetById(int id) throws NotFoundException;
    Pet UpdatePet(int id, Pet newPet);
    void DeletePet(int id);
    void DeletePet(String petName);
    Optional<Pet> FindAllPetByAnimalType(String animalType);
    Optional<Pet> FindAllPetByBreed(String breed);
    Optional<PetNameAndBreed> FindAnimalNameAndBreed();
    List<Integer> GetPetStatistics();
    Pet updatePetName(int id, String petName) throws NotFoundException;
}
