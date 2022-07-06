package com.example.backclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String specialization;
    private String City;
    private String email;
    private String password;
    private int startWorkingHour;
    private int endWorkingHour;
    private List<Long> appointmentsId;

    public DoctorDto(String firstname, String lastname, String specialization, String city, String email,
                     String password, int startWorkingHour, int endWorkingHour, List<Long> appointmentsId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialization = specialization;
        City = city;
        this.email = email;
        this.password = password;
        this.startWorkingHour = startWorkingHour;
        this.endWorkingHour = endWorkingHour;
        this.appointmentsId = appointmentsId;
    }
}
