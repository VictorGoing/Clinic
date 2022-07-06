package com.example.backclinic.controller;

import com.example.backclinic.domain.Doctor;
import com.example.backclinic.dto.DoctorDto;
import com.example.backclinic.mapper.DoctorMapper;
import com.example.backclinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @GetMapping(value="{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long doctorId){
        Doctor doctor = doctorService.getDoctorById(doctorId);
        return ResponseEntity.ok(doctorMapper.mapToDoctorDto(doctor));
    }

    @GetMapping(value ="getListOfDoctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctorMapper.mapToDoctorDtoList(doctors));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "register")
    public ResponseEntity<Void> registerDoctor(@RequestBody DoctorDto doctorDto){
        doctorService.registerDoctor(doctorMapper.mapToDoctor(doctorDto));
        return ResponseEntity.ok().build();
    }

}
