package com.example.myproject.controllers.rest;

import com.example.myproject.entities.Household;
import com.example.myproject.services.HouseholdService;
import com.example.myproject.services.PetService;
import com.example.myproject.services.exceptions.BadDataException;
import lombok.AllArgsConstructor;
import com.example.myproject.services.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/myapi/households")
public class HouseholdWebService {
    private final HouseholdService householdService;
    private final PetService petService;

    @GetMapping({"/", ""})
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping({"/nopet"})
    public Optional<Household> getHouseHoldNoPets(){
        return householdService.findHouseholdWithoutPets();
    }

    @GetMapping({"/{eircode}"})
    public Household getHouseHoldByEircode(@PathVariable String eircode) throws NotFoundException{
        System.out.println(eircode);
        return householdService.findHouseholdByEircode(eircode);
    }

    @DeleteMapping({"/{eircode}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHousehold(@PathVariable String eircode) throws NotFoundException{
        householdService.deleteHouseholdByEircode(eircode);
        System.out.println("Household with eircode: " + eircode + " deleted");
    }

    @PostMapping({"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Household addHousehold(@RequestBody @Valid Household newHousehold) throws NotFoundException, BadDataException {
        Household household = new Household(newHousehold.getEircode(), newHousehold.getNumberOfOccupants(), newHousehold.getMaxNumberOfOccupants(),
                newHousehold.getOwnerOccupied());
        return householdService.CreateHousehold(household);
    }
}

