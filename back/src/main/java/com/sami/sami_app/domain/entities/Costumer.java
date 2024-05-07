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
*---------------------------------------------------------------------------------------------------------------------------
*The "COSTUMER" entity is created in order to manage the user's role with other entities. 
The costumer class defines the attributes of a costumer, such as its unique identifier.-------------------------------------------------
*/
@Entity(name = "costumer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;
}

