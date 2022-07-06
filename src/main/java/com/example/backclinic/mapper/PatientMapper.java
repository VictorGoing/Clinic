package com.example.backclinic.mapper;

import com.example.backclinic.domain.Patient;
import com.example.backclinic.dto.PatientDto;
import com.example.backclinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientMapper {

    private AppointmentService appointmentService;

    public Patient mapToPatient(PatientDto patientDto){
        return new Patient(
                patientDto.getFirstname(),
                patientDto.getLastname(),
                patientDto.getEmail(),
                patientDto.getPassword()
                );
    }

    public PatientDto mapToPatientDto(Patient patient){
        return new PatientDto(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getPassword(),
                patient.getAppointments().stream().map(appointment -> appointment.getId()).collect(Collectors.toList())
        );
    }
}
