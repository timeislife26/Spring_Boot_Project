package com.example.myproject.controllers;

import com.example.myproject.entities.Pet;
import com.example.myproject.entities.Household;
import com.example.myproject.services.PetService;
import com.example.myproject.services.HouseholdService;
import com.example.myproject.services.exceptions.BadDataException;
import com.example.myproject.services.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class GraphQLAPI {
    private PetService petService;
    private HouseholdService householdService;

    @QueryMapping
    List<Household> findAllHouseHold() { return householdService.getAllHouseholds();}

    @QueryMapping
    Optional<Pet> findPetsByAnimalType(@Argument String animalType) throws NotFoundException {
        return petService.FindAllPetByAnimalType(animalType);
    }

    @QueryMapping
    Pet findPetByID(@Argument int id) throws NotFoundException {
        return petService.GetPetById(id);
    }

    @QueryMapping
    Household findHouseholdByEircode(@Argument String eircode) throws NotFoundException {
        return householdService.findHouseholdByEircode(eircode);
    }

    @QueryMapping
    List<Integer> GetPetStatistics(){
        return petService.GetPetStatistics();
    }

    @MutationMapping
    Household createHousehold(@Valid @Argument("household") Household newHousehold) throws BadDataException, NotFoundException {
        Household household = new Household(newHousehold.getEircode(), newHousehold.getNumberOfOccupants(), newHousehold.getMaxNumberOfOccupants(), newHousehold.getOwnerOccupied());
        return householdService.CreateHousehold(household);
    }

    @MutationMapping
    int deleteHousehold(@Argument String eircode) throws NotFoundException {
        householdService.deleteHouseholdByEircode(eircode);
        return 1;
    }

    @MutationMapping
    int deletePet(@Argument int id) throws NotFoundException {
        petService.DeletePet(id);
        return 1;
    }
}

