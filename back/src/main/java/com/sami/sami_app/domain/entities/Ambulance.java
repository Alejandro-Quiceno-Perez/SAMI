package com.sami.sami_app.domain.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*-
*-----------------------------------------------------------------------------------------------------------------------
* The Ambulance class defines the attributes of an ambulance, such as its unique identifier,
* vehicle plate number, ambulance type, and associations with drivers and emergency medical technicians (EMTs).
* These attributes are mapped to corresponding columns in the database using the Column decorator, 
* with specific sizes and specifications according to requirements.
*------------------------------------------------------------------------------------------------------------------------
*/

@Entity(name = "Ambulance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ambulance")
    private Long idAmbulance;

    @Column(name="vehicle_plate", nullable = false, length = 10)
    private String vehiclePlate;

    @Column(name="ambulance_type", nullable = false, length = 50)
    private String ambulanceType;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id_driver")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "emt_id", referencedColumnName = "id_emt")
    private Emt emt; 
}
