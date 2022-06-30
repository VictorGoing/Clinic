package com.example.backclinic.controller;

import com.example.backclinic.dto.PatientDto;
import com.example.backclinic.mapper.PatientMapper;
import com.example.backclinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    PatientService patientService;
    PatientMapper patientMapper;

    /*@GetMapping(value = "/hello/{patientId}")
    public ResponseEntity<PatientDto> hello(){

    }*/


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerUser(@RequestBody PatientDto patientDto){
        patientService.registerPatient(patientMapper.mapToPatient(patientDto));
        return ResponseEntity.ok().build();
    }
}
