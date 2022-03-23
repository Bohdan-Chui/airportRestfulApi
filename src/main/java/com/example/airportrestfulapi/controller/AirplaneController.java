package com.example.airportrestfulapi.controller;

import com.example.airportrestfulapi.model.AirCompany;
import com.example.airportrestfulapi.model.Airplane;
import com.example.airportrestfulapi.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
    final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PatchMapping("/company/change")
    public ResponseEntity<Airplane> changeCompany(@RequestParam("planeId") Airplane planeId,
                                                  @RequestParam("destinationCompanyId") AirCompany destinationCompanyId) {
        return ResponseEntity
                .ok()
                .body(airplaneService.changePlaneCompany(planeId, destinationCompanyId));
    }

    @PostMapping("/new")
    public ResponseEntity<Airplane> addNewPlane(@Valid @RequestBody Airplane airplane) {
        return ResponseEntity
                .ok()
                .body(airplaneService.saveAirpane(airplane));
    }
}
