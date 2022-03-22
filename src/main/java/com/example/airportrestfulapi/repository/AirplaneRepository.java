package com.example.airportrestfulapi.repository;

import com.example.airportrestfulapi.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
}
