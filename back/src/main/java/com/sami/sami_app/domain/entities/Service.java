package com.sami.sami_app.domain.entities;

import com.sami.sami_app.util.enums.StatusService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.websocket.Decoder.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    private Text anamnesis;

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
