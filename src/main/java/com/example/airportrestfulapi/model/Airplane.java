package com.example.airportrestfulapi.model;

import com.example.airportrestfulapi.converter.AircompanyIdToObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NonNull
    @NotBlank
    private String name;

    @Column(name = "factory_serial_number")
    @NonNull
    @NotBlank
    private String factorySerialNumber;

    @Column(name = "number_flights")
    @NonNull
    @NotBlank
    private Integer numberOfFlights;

    @Column(name = "flight_distance")
    @NonNull
    @NotBlank
    private Integer flightDistance;

    @Column(name = "fuel_capacity")
    @NonNull
    @NotBlank
    private Integer fuelCapacity;

    @Column(name = "type")
    @NonNull
    @NotBlank
    private String type;

    @Column(name = "created_date")
//    @NonNull
//    @NotBlank
    private LocalDate createdAt;

    @ManyToOne
    @JsonDeserialize(converter = AircompanyIdToObject.class)
    private AirCompany airCompany;

}
