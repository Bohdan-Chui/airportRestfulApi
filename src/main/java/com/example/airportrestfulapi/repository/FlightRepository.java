package com.example.airportrestfulapi.repository;

import com.example.airportrestfulapi.model.Flight;
import com.example.airportrestfulapi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> getAllByFlightStatusAndAirCompany_NameIgnoreCase(Status status, String name);

    List<Flight> getAllByFlightStatus(Status status);
}
