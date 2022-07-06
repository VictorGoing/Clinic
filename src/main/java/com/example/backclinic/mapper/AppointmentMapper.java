package com.example.backclinic.mapper;

import com.example.backclinic.domain.Appointment;
import com.example.backclinic.dto.AppointmentDto;
import com.example.backclinic.exception.ClinicUserNotFound;
import com.example.backclinic.service.DoctorService;
import com.example.backclinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentMapper {

    private final DoctorService doctorService;
    private final PatientService patientService;

    public Appointment mapToAppointment(AppointmentDto appointmentDto) throws ClinicUserNotFound {
        return new Appointment(
                appointmentDto.getDate(),
                patientService.getPatientById(appointmentDto.getPatientId()),
                doctorService.getDoctorById(appointmentDto.getDoctorId())
        );
    }

    public AppointmentDto mapToAppointmentDto(Appointment appointment){
        return new AppointmentDto(
                appointment.getId(),
                appointment.getDate(),
                appointment.getPatient().getId(),
                appointment.getDoctor().getId()
        );
    }

    public List<Appointment> mapToAppointmentList(List<AppointmentDto> appointmentDtoList){
        List<Appointment> collect = new ArrayList<>();
        for(AppointmentDto appointmentDto: appointmentDtoList){
            Appointment appointment = null;
            try {
                appointment = mapToAppointment(appointmentDto);
            }catch (ClinicUserNotFound e){
                e.printStackTrace();
            }
            collect.add(appointment);
        }
        return collect;
    }

    public List<AppointmentDto> mapToAppointmentDtoList(List<Appointment> appointmentList){
        return appointmentList.stream()
                .map(e -> mapToAppointmentDto(e))
                .collect(Collectors.toList());
    }

}
