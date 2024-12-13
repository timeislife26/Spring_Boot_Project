package com.example.myproject.daos;

import com.example.myproject.entities.Household;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {
    Optional<Household> findByEircode(String Eircode);

    @EntityGraph(attributePaths = {"pets"})
    Optional<Household> findbyEircodeEagarly(String Eircode);

    @Query("SELECT h From Household h WHERE h.pets IS empty ")
    Optional<Household> findHouseholdNoPets();

    void deleteHouseholdByEircode(String eircode);

    @Query("select h From Household h where h.ownerOccupied is false")
    Optional<Household> findbyHouseholdOwnerOccupied();


}
