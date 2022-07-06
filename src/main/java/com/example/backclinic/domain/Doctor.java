package com.example.backclinic.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STARTWORKINGHOURS")
    private int startWorkingHours;

    @Column(name = "ENDWORKINGHOURS")
    private int endWorkingHours;

    @OneToMany(
            targetEntity = Appointment.class,
            mappedBy = "doctor",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public Doctor(String firstname, String lastname, String specialization, String city, String email,
                  String password, int startWorkingHours, int endWorkingHours, List<Appointment> appointments) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialization = specialization;
        this.city = city;
        this.email = email;
        this.password = password;
        this.startWorkingHours = startWorkingHours;
        this.endWorkingHours = endWorkingHours;
        this.appointments = appointments;
    }

    @Override
    public String getRole() {
        return role;
    }
}
