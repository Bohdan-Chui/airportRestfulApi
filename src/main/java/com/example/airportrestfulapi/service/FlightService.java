package com.example.airportrestfulapi.service;

import com.example.airportrestfulapi.model.Flight;
import com.example.airportrestfulapi.model.Status;
import com.example.airportrestfulapi.repository.AirCompanyRepository;
import com.example.airportrestfulapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    public static final Integer TIME_HOURS = 24;

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AirCompanyRepository airCompanyRepository;

    public List<Flight> getFlightsByNameAndStatus(Status status, String name){
        return flightRepository.getAllByFlightStatusAndAirCompany_NameIgnoreCase(status, name);
    }

    public List<Flight> getAllFlightsWhereStarusAndFlightTimeIsMoreThan(Status status){
       return flightRepository.getAllByFlightStatus(status)
                .stream()
                .filter(s->s.getStartedAt().until(LocalDateTime.now(), ChronoUnit.HOURS) > TIME_HOURS)
                .collect(Collectors.toList());
    }

    public Flight saveFlight(Flight flight){
        flight.setFlightStatus(Status.PENDING);
        flight.setCreatedAt(LocalDateTime.now());
        return flightRepository.save(flight);
    }

    public Flight changeStatus(Integer id, Status status) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isEmpty())
            throw new EntityNotFoundException("No flight by that id");
        Flight flight = optionalFlight.get();
        switch (status) {
            case DELAYED:
                flight.setFlightStatus(Status.DELAYED);
                flight.setDelayStartedAt(LocalDateTime.now());
                break;
            case ACTIVE:
                flight.setFlightStatus(Status.ACTIVE);
                flight.setStartedAt(LocalDateTime.now());
                break;
            case COMPLETED:
                flight.setFlightStatus(Status.COMPLETED);
                flight.setEndedAt(LocalDateTime.now());
                break;
            default:
                throw  new NoSuchElementException("That status isn`t supported");
        }
        return flightRepository.save(flight);
    }

    public List<Flight> optionalTask(Status status){
        return flightRepository.getAllByFlightStatus(status).stream()
                .filter(s->{
                    if(s.getStartedAt()==null || s.getEndedAt()==null || s.getEstimatedFlightTime() == null)
                        return false;
                    return Duration.between(s.getStartedAt(), s.getEndedAt()).compareTo(s.getEstimatedFlightTime()) > 0;
                })
                .collect(Collectors.toList());
    }

}
