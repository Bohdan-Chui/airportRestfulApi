package com.example.airportrestfulapi.repository;

import com.example.airportrestfulapi.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Integer> {
    Optional<AirCompany> findByName(String name);
}
