package com.example.airportrestfulapi.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "air_company")
public class AirCompany {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "company_type")
    private String companyType;

    @Column(name = "founded_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundedAt;

}