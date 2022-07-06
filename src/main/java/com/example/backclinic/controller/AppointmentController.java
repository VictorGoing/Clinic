package com.example.backclinic.controller;

import com.example.backclinic.domain.Appointment;
import com.example.backclinic.domain.Doctor;
import com.example.backclinic.dto.AppointmentDto;
import com.example.backclinic.dto.DoctorDto;
import com.example.backclinic.dto.PatientDto;
import com.example.backclinic.exception.ClinicUserNotFound;
import com.example.backclinic.mapper.AppointmentMapper;
import com.example.backclinic.mapper.DoctorMapper;
import com.example.backclinic.mapper.LocalDateTimeMapper;
import com.example.backclinic.mapper.PatientMapper;
import com.example.backclinic.service.AppointmentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;
    private final LocalDateTimeMapper localDateTimeMapper;


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "check")
    public ResponseEntity<Boolean> checkAppointment(@RequestBody AppointmentDto appointmentDto){
        Boolean bool = appointmentService.checkAppointment(appointmentDto.getDate(),appointmentDto.getDoctorId());
        return ResponseEntity.ok(bool);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "create")
    public ResponseEntity<Void> createAppointment(@RequestBody AppointmentDto appointmentDto) throws ClinicUserNotFound {
        appointmentService.saveAppointment(appointmentMapper.mapToAppointment(appointmentDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "list/{patientId}")
    public ResponseEntity<List<AppointmentDto>> getAllAppointmentsByPatientId(@PathVariable Long patientId){
        List<AppointmentDto> appointmentDtoList = appointmentMapper.mapToAppointmentDtoList(
                appointmentService.getListOfAppointmentsByPatientId(patientId));
        return ResponseEntity.ok(appointmentDtoList);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "edit")
    public ResponseEntity<Appointment> editAppointment(@RequestBody AppointmentDto appointmentDto) throws ClinicUserNotFound {
        Appointment appointment = appointmentMapper.mapToAppointment(appointmentDto);
        Appointment savedAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }
}
