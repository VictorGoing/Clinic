package com.example.backclinic.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DOCTORS")
public class Doctor implements ClinicUser{

    private static String role = "DOCTOR";

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "SPECIALIZATION")
    private String specialization;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STARTWORKINGHOURS")
    private int startWorkingHours;

    @Column(name = "ENDWORKINGHOURS")
    private int endWorkingHours;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PATIENTPASSWORD")
    private String password;

    public Doctor(String firstname, String lastname, String specialization, String city, int startWorkingHours, int endWorkingHours) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialization = specialization;
        this.city = city;
        this.startWorkingHours = startWorkingHours;
        this.endWorkingHours = endWorkingHours;
    }

    @Override
    public String getRole() {
        return role;
    }
}
