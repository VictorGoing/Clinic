package com.example.backclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PATIENTS")
public class Patient implements ClinicUser{

    private static String role = "PATIENT";

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long Id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PATIENTPASSWORD")
    private String password;

    @Override
    public String getRole() {
        return role;
    }
}
