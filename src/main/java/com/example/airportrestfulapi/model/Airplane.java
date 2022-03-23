package com.example.airportrestfulapi.model;

import com.example.airportrestfulapi.converter.AircompanyIdToObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
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
//    @NonNull
//    @NotBlank
    private Integer numberOfFlights;

    @Column(name = "flight_distance")
//    @NonNull
//    @NotBlank
    private Integer flightDistance;

    @Column(name = "fuel_capacity")
//    @NonNull
//    @NotBlank
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Airplane airplane = (Airplane) o;
        return id != null && Objects.equals(id, airplane.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
