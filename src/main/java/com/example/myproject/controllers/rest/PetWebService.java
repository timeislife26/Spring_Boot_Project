package com.example.myproject.controllers.rest;


import com.example.myproject.entities.Household;
import com.example.myproject.entities.Pet;
import com.example.myproject.services.HouseholdService;
import com.example.myproject.services.PetService;
import com.example.myproject.services.exceptions.BadDataException;
import lombok.AllArgsConstructor;
import com.example.myproject.services.exceptions.NotFoundException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/myapi/pets")
public class PetWebService {
    private PetService petService;
    private HouseholdService householdService;

    @GetMapping({"/", ""})
    public List<Pet> getAllHeroes() {
        return petService.GetAllPets();
    }

    @GetMapping({"/{id}"})
    public Pet getPetByID(@PathVariable("id") int id) throws NotFoundException {
        System.out.println(id);
        return petService.GetPetById(id);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePetByID(@PathVariable("id") int id) throws NotFoundException {
        petService.DeletePet(id);
        System.out.println("Pet with id: " + id + " deleted");

    }

    @PostMapping({"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Pet addPet(@RequestBody Pet newPet) throws NotFoundException, BadDataException {
        Household household = null;
        if (newPet.getHousehold() != null) {
            household = householdService.findHouseholdByEircode(newPet.getHousehold().getEircode());
        }
        Pet pet = new Pet(newPet.getId(), newPet.getName(), newPet.getAnimalType(), newPet.getBreed(), newPet.getAge(), household);
        return petService.CreatePet(pet);
    }

    @PatchMapping("/{id}/{NewName}")
    public void ChangePetName(@PathVariable("id") int id, @PathVariable("NewName") String newName) throws BadDataException, NotFoundException {
        petService.updatePetName(id, newName);
    }
}
