package com.example.backclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private List<Long> appointmentsId;

    public PatientDto(String firstname, String lastname, String email, String password, List<Long> appointmentsId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.appointmentsId = appointmentsId;
    }
}
