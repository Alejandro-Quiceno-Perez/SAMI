package com.sami.sami_app.domain.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/*-
*-----------------------------------------------------------------------------------------------------------------------
* The Ambulance class defines the attributes of an ambulance, such as its unique identifier,
* vehicle plate number, ambulance type, and associations with drivers and emergency medical technicians (EMTs).
* These attributes are mapped to corresponding columns in the database using the Column decorator, 
* with specific sizes and specifications according to requirements.
*------------------------------------------------------------------------------------------------------------------------
*/

@Entity(name="ambulance")

public class Ambulance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ambulance")
    private long idAmbulance;

    @Column(name="vehicle_plate",length = 6, nullable = false)
    private String vehiclePlate;

    @Column(name="ambulance_type",length = 20, nullable = false)
    private String ambulanceType;

    @OneToOne
    @JoinColumn(name = "fk_id_driver", referencedColumnName = "id_driver")
    private Driver driver;

   


    
}