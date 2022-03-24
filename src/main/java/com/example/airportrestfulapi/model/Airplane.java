package com.example.airportrestfulapi.model;

import com.example.airportrestfulapi.converter.AircompanyIdToObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.hibernate.annotations.Cascade;

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
    private Integer numberOfFlights;

    @Column(name = "flight_distance")
    private Integer flightDistance;

    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;

    @Column(name = "type")
    @NonNull
    @NotBlank
    private String type;

    @Column(name = "created_date")
    private LocalDate createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonDeserialize(converter = AircompanyIdToObject.class)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private AirCompany airCompany;
}