package com.example.myproject.services;

import com.example.myproject.daos.PetRepository;
import com.example.myproject.daos.dtos.PetNameAndBreed;
import com.example.myproject.entities.Pet;
import com.example.myproject.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Data
@AllArgsConstructor
public class PetServiceImp implements PetService {
    private PetRepository petRepository;

    @Override
    public Pet CreatePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> GetAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet GetPetById(int id) throws NotFoundException {
        return petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet not found id: " + id));
    }

    @Override
    public Pet UpdatePet(int id, Pet newPet) {
        return petRepository.updatePetById(newPet);
    }


    @Override
    public void DeletePet(int id) {
        petRepository.deleteById(id);
    }

    @Override
    public void DeletePet(String petName) {
        petRepository.deletePetsByName(petName);
    }

    @Override
    public Optional<Pet> FindAllPetByAnimalType(String animalType) {
        return petRepository.findPetsByAnimalType(animalType);
    }

    @Override
    public Optional<Pet> FindAllPetByBreed(String breed) {
        return petRepository.findPetsByBreed(breed);
    }

    @Override
    public Optional<PetNameAndBreed> FindAnimalNameAndBreed() {
        return petRepository.findPetNameAndBreed();
    }

    public List<Integer> FindAllPetAges(){
        List<Integer> petAges = new ArrayList<>();
        List<Pet> allPets = petRepository.findAll();
        for (Pet pet : allPets) {
            petAges.add(pet.getAge());
        }
        return petAges;
    }

    @Override
    public List<Integer> GetPetStatistics() {
        List<Integer> petStatistics = new ArrayList<>();
        List<Integer> petAges = FindAllPetAges();
        int totalPetsCount = petAges.size();
        int totalAgeOfAllPets =0;
        for (int i = 0; i < totalPetsCount; i++) {
            totalAgeOfAllPets += petAges.get(i);
        }
        int averageAge = totalAgeOfAllPets / totalPetsCount;
        /*
        System.out.println("There are " + totalPetsCount + " pets in the database");
        System.out.println("Total age of all the pets together: " + totalAgeOfAllPets);
        System.out.println("Average age of all the pets together: " + averageAge);*/
        petStatistics.add(totalPetsCount);
        petStatistics.add(averageAge);
        petStatistics.add(averageAge);
        return petStatistics;
    }

    @Override
    public Pet updatePetName(int id, String petName) throws NotFoundException {
        Pet pet = GetPetById(id);
        pet.setName(petName);
        petRepository.save(pet);
        return pet;
    }


}
