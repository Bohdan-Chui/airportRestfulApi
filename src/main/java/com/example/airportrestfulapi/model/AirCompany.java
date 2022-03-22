package com.example.airportrestfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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
    @NonNull
    private String name;
    @Column(name = "company_type")
    @NonNull
    private String companyType;
    @Column(name = "founded_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundedAt;

}
