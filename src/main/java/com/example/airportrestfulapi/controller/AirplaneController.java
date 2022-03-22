package com.example.airportrestfulapi.controller;

import com.example.airportrestfulapi.model.Airplane;
import com.example.airportrestfulapi.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
    @Autowired
    AirplaneService airplaneService;
    @PatchMapping("/change-company")
    public ResponseEntity<HttpStatus> changeCompany(@RequestParam("planeId")Integer planeId,
                                                    @RequestParam("destinationCompanyId") Integer destinationCompanyId){
        airplaneService.changePlaneCompany(planeId, destinationCompanyId);
        return ResponseEntity.ok(/*airplaneService.changePlaneCompany(planeId,destinationCompanyId)*/ HttpStatus.OK);
    }

    @PostMapping ("/new-plane")
    public ResponseEntity<Airplane> addNewPlane(/*@Valid*/ @RequestBody Airplane airplane){
        return ResponseEntity.ok(airplaneService.saveAirpane(airplane));
    }
}
