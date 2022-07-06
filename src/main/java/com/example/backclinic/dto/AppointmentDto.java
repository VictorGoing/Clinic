package com.example.backclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private Long id;
    private LocalDateTime date;
    private Long patientId;
    private Long doctorId;

    public AppointmentDto(LocalDateTime date, Long patientId, Long doctorId) {
        this.date = date;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }
}
