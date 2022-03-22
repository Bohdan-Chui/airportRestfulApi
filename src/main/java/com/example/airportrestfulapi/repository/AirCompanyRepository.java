package com.example.airportrestfulapi.repository;

import com.example.airportrestfulapi.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCompanyRepository extends JpaRepository<AirCompany,Integer> {
}
