package com.example.airportrestfulapi.model;

import com.example.airportrestfulapi.converter.AircompanyIdToObject;
import com.example.airportrestfulapi.converter.AirplaneIdToObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

//    @NonNull
//    @NotBlank
    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    private Status flightStatus;

//    @NonNull
//    @NotBlank
    @Column(name = "departure_country")
    private String departureCountry;

//    @NonNull
//    @NotBlank
    @Column(name = "destination_country")
    private String destinationCountry;

//    @NonNull
//    @NotBlank
    @Column(name = "distance")
    private Double distance;

//    @NonNull
//    @NotBlank
    @Column(name = "estimated_flight_time")
    private Duration estimatedFlightTime;

//    @NonNull
//    @NotBlank
    @Column(name = "started_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startedAt;

//    @NonNull
//    @NotBlank
    @Column(name = "ended_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endedAt;

//    @NonNull
//    @NotBlank
    @Column(name = "delay_started_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime delayStartedAt;

//    @NonNull
//    @NotBlank
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
