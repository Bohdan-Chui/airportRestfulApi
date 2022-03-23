package com.example.airportrestfulapi.controller;

import com.example.airportrestfulapi.model.Flight;
import com.example.airportrestfulapi.model.Status;
import com.example.airportrestfulapi.repository.FlightRepository;
import com.example.airportrestfulapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    final FlightService flightService;
    final FlightRepository repository;

    @Autowired
    public FlightController(FlightService flightService, FlightRepository repository) {
        this.flightService = flightService;
        this.repository = repository;
    }

    @GetMapping("/company/status")
    public ResponseEntity<List<Flight>> getAllByFlightStatusAndAirCompanyName(@RequestParam("status") Status status,
                                                                              @RequestParam("companyName") String name) {

        return ResponseEntity
                .ok()
                .body(flightService.getFlightsByNameAndStatus(status, name));
    }

    @GetMapping("/active/day")
    public ResponseEntity<List<Flight>> getAllActiveFlightsWhereFlightTimeIsMoreThanOneDay() {
        return ResponseEntity
                .ok()
                .body(flightService.getAllFlightsWhereStarusAndFlightTimeIsMoreThan(Status.ACTIVE));
    }

    @PostMapping("/new")
    public ResponseEntity<Flight> addNewFlight(@Valid @RequestBody Flight flight) {
        return ResponseEntity
                .ok()
                .body(flightService.saveFlight(flight));

    }

    @PatchMapping("/status")
    public ResponseEntity<Flight> changeStatus(@RequestParam(name = "id") Integer id,
                                               @RequestParam(name = "status") Status status) {
        return ResponseEntity
                .ok()
                .body(flightService.changeStatus(id, status));
    }

    @GetMapping("/optional")
    public ResponseEntity<List<Flight>> COMPLETEDStatusAndDifferenceBetweenStarteAndEndedTime() {
        return ResponseEntity
                .ok()
                .body(flightService.optionalTask(Status.COMPLETED));
    }
}
