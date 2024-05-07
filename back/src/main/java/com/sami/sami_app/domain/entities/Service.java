package com.sami.sami_app.domain.entities;

import com.sami.sami_app.util.enums.StatusService;
import com.sami.sami_app.domain.entities.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.websocket.Decoder.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
    This entity is used to create the service, it has ID, location latitude, location length, 
    the state of the service, a text type description.
    It also has many-to-one references with Hospital, one-to-one with Ambulance, 
    one-to-one with client.... Which allows a relationship between the Service entity and the 
    other entities.
 */
@Entity(name = "service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Long idService;

    private double latidudeLocation;

    private double longitudeLocation;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusService statusService;

    @Lob
    private String anamnesis;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_hospital")
    private Hospital hospital;

    @OneToOne
    @JoinColumn(referencedColumnName = "id_ambulance")
    private Ambulance ambulance;

    @OneToOne
    @JoinColumn(referencedColumnName = "id_customer")
    private Customer customer;
}
