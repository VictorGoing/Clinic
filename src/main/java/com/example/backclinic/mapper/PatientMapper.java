package com.example.backclinic.mapper;

import com.example.backclinic.domain.Patient;
import com.example.backclinic.dto.PatientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientMapper {

    public Patient mapToPatient(PatientDto patientDto){
        return new Patient(
                patientDto.getId(),
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
                patient.getPassword()
        );
    }
}
