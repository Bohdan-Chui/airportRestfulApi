package com.example.airportrestfulapi.service;

import com.example.airportrestfulapi.model.AirCompany;
import com.example.airportrestfulapi.model.Airplane;
import com.example.airportrestfulapi.repository.AirCompanyRepository;
import com.example.airportrestfulapi.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AirplaneService {
    AirplaneRepository airplaneRepository;
    AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository, AirCompanyRepository airCompanyRepository) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyRepository = airCompanyRepository;
    }

    public Airplane changePlaneCompany(Airplane planeId, AirCompany destinationCompanyId) {
        planeId.setAirCompany(destinationCompanyId);
        return airplaneRepository.save(planeId);
    }

    public Airplane saveAirpane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public Airplane getPlane(Integer id) {
        Optional<Airplane> airplaneOptional = airplaneRepository.findById(id);
        if (airplaneOptional.isPresent()) {
            return airplaneOptional.get();
        } else throw new EntityNotFoundException("no airplane with than id ");
    }
}
