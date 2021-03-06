package com.example.airportrestfulapi.service;

import com.example.airportrestfulapi.model.AirCompany;
import com.example.airportrestfulapi.repository.AirCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AirCompanyService {

    private final AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirCompanyService(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    public AirCompany saveAirCompany(AirCompany airCompany) {
        if(airCompanyRepository.findByName(airCompany.getName()).isPresent())
            throw new EntityExistsException("Company with that name already exists");
        return airCompanyRepository.save(airCompany);
    }

    public List<AirCompany> getCompanies() {
        return airCompanyRepository.findAll();
    }

    public AirCompany getCompany(Integer id) {
        Optional<AirCompany> airCompanyOptional = airCompanyRepository.findById(id);
        if (airCompanyOptional.isPresent()) {
            return airCompanyOptional.get();
        } else throw new EntityNotFoundException("no airCompany with than id ");
    }

    public AirCompany update(AirCompany airCompany) {
        if (!airCompanyRepository.existsById(airCompany.getId())) {
            throw new IllegalArgumentException("aircompany problem");
        }
        return airCompanyRepository.save(airCompany);
    }

    public void deleteById(Integer id) {
        airCompanyRepository.deleteById(id);
    }

}
