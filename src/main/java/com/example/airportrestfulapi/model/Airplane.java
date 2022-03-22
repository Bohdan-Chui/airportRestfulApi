package com.example.airportrestfulapi.model;

import com.example.airportrestfulapi.converter.AircompanyIdToObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "factory_serial_number")
    private String factorySerialNumber;

    @Column(name = "number_flights")
    private Integer numberOfFlights;

    @Column(name = "flight_distance")
    private Integer flightDistance;

    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;

    @Column(name = "type")
    private String type;

    @Column(name = "created_date")
    private LocalDate createdAt;

    @ManyToOne
    @JsonDeserialize(converter = AircompanyIdToObject.class)
    private AirCompany airCompany;

}
