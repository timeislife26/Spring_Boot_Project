package com.example.myproject.services;

import com.example.myproject.entities.Household;
import com.example.myproject.services.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseholdService {
    Household CreateHousehold(Household household);
    List<Household> getAllHouseholds();
    Household findHouseholdByEircode(String eircode) throws NotFoundException;
    Household updateHousehold(Household household);
    void deleteHousehold(int id);
    void deleteHouseholdByEircode(String eircode);
    Optional<Household> findHouseholdWithoutPets();
    Optional<Household> findHouseholdOwnerOccupied();
    void GetHouseholdStatistics();
}
