package com.sami.sami_app.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "hospital")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospital")
    private Long idHospital;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String address;
    @Column(name = "latitude_location", precision = 10, scale = 6, nullable = false)
    private double latitudeLocation;
    @Column(name = "longitude_location", precision = 10, scale = 6, nullable = false)
    private double longitudeLocation;
    @Column(name = "complexity_grade", length = 50, nullable = false)
    private String complexityGrade;
    @Column(length = 255, nullable = false)
    private String specialty;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Service> services;
}
