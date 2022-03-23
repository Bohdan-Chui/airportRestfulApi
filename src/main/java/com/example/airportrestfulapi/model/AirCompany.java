package com.example.airportrestfulapi.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "air_company")
public class AirCompany {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
//    @NonNull
//    @NotBlank
    private String name;

    @Column(name = "company_type")
//    @NonNull
//    @NotBlank
    private String companyType;

    @Column(name = "founded_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NonNull
//    @NotBlank
    private LocalDate foundedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AirCompany that = (AirCompany) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
