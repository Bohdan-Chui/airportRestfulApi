package com.example.airportrestfulapi.controller;

import com.example.airportrestfulapi.model.AirCompany;
import com.example.airportrestfulapi.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aircompany")
public class AirCompanyController {

    @Autowired
    private AirCompanyService airCompanyService;

    @PostMapping(value ="/save")
    public ResponseEntity<AirCompany> saveAirCompany(@Valid  @RequestBody AirCompany airCompany){
        AirCompany airCompany1 = airCompanyService.saveAirCompany(airCompany);
        return  ResponseEntity.ok().body(airCompany1);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AirCompany> getAircompany(@PathVariable(name = "id")Integer id){
        return ResponseEntity.ok().body(airCompanyService.getCompany(id));
    }

    @GetMapping(value = "/companies")
    public ResponseEntity<List<AirCompany>> getCompanies(){
        return ResponseEntity.ok().body(airCompanyService.getCompanies());
    }
    @PatchMapping(value = "/update")
    public ResponseEntity getAircompany(@Valid @RequestBody AirCompany airCompany){
        return ResponseEntity.ok().body(airCompanyService.update(airCompany));
    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<HttpStatus> geleteCompany(@PathVariable Integer id){
        airCompanyService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}