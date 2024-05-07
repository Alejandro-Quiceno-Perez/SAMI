package com.sami.sami_app.domain.entities;

import com.sami.sami_app.util.enums.RhType;
import com.sami.sami_app.util.enums.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*-
*---------------------------------------------------------------------------------------------------------------------------
The "user" class defines the attributes related to the user, the unique identifier, the type of user and the user's personal information such as name, surname, blood type.
*---------------------------------------------------------------------------------------------------------------------------
*/
@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(length = 30 , nullable = false )
    private String firstName;

    @Column(length = 30, nullable = false)
    private String lastName;

   @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RhType rhType;

    @Column(length = 15, nullable = false)
    private String phone;


    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Customer customer;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Emt emt;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Driver driver;
}
