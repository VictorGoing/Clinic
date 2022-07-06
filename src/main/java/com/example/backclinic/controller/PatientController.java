package com.example.backclinic.controller;

import com.example.backclinic.dto.PatientDto;
import com.example.backclinic.exception.ClinicUserNotFound;
import com.example.backclinic.mapper.PatientMapper;
import com.example.backclinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "register")
    public ResponseEntity<Void> registerUser(@RequestBody PatientDto patientDto){
        patientService.registerPatient(patientMapper.mapToPatient(patientDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getPatientByEmail/{email}")
    public ResponseEntity<PatientDto> getPatientByEmail(@PathVariable String email) throws ClinicUserNotFound {
        PatientDto patientDto = patientMapper.mapToPatientDto(patientService.getPatientByEmail(email));
        return ResponseEntity.ok(patientDto);
    }

    @GetMapping(value = "/getPatientById/{patientId}")
    public ResponseEntity<PatientDto> getPatientByEmail(@PathVariable Long patientId) throws ClinicUserNotFound {
        PatientDto patientDto = patientMapper.mapToPatientDto(patientService.getPatientById(patientId));
        return ResponseEntity.ok(patientDto);
    }

    @DeleteMapping(value = "/deletePatient/{patientId}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long patientId){
        patientService.deletePatientById(patientId);
        return ResponseEntity.ok().build();
    }
}
