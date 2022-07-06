package com.example.backclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PATIENTPASSWORD")
    private String password;

    @OneToMany(
            targetEntity = Appointment.class,
            mappedBy = "patient",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    @Override
    public String getRole() {
        return role;
    }

    public Patient(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
