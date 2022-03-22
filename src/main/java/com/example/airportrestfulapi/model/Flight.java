package com.example.airportrestfulapi.model;

import com.example.airportrestfulapi.converter.AircompanyIdToObject;
import com.example.airportrestfulapi.converter.AirplaneIdToObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    private Status flightStatus;

    @Column(name = "departure_country")
    private String departureCountry;

    @Column(name = "destination_country")
    private String destinationCountry;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "estimated_flight_time")
    private Duration estimatedFlightTime;

    @Column(name = "started_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startedAt;

    @Column(name = "ended_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endedAt;

    @Column(name = "delay_started_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime delayStartedAt;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonDeserialize(converter = AircompanyIdToObject.class)
    private AirCompany airCompany;

    @OneToOne
    @JsonDeserialize(converter = AirplaneIdToObject.class)
    private Airplane airplane;
}
