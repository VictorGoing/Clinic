package com.example.backclinic.mapper;

import com.example.backclinic.domain.Doctor;
import com.example.backclinic.dto.DoctorDto;
import com.example.backclinic.service.AppointmentService;
import com.example.backclinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorMapper {

    private final AppointmentService appointmentService;

    public DoctorDto mapToDoctorDto(Doctor doctor){
        return new DoctorDto(
                doctor.getId(),
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getSpecialization(),
                doctor.getCity(),
                doctor.getEmail(),
                doctor.getPassword(),
                doctor.getStartWorkingHours(),
                doctor.getEndWorkingHours(), 
                doctor.getAppointments().stream().map(e -> e.getId()).collect(Collectors.toList())
        );
    }

    public Doctor mapToDoctor(DoctorDto doctorDto){
        return new Doctor(
            doctorDto.getFirstname(),
            doctorDto.getLastname(),
            doctorDto.getSpecialization(),
            doctorDto.getCity(),
            doctorDto.getEmail(),
            doctorDto.getPassword(),
            doctorDto.getStartWorkingHour(),
            doctorDto.getEndWorkingHour(),
            appointmentService.getListOfAppointmentsById(doctorDto.getAppointmentsId())
        );
    }
    
    public List<DoctorDto> mapToDoctorDtoList(List<Doctor> doctorList){
        return doctorList.stream()
                .map(e -> mapToDoctorDto(e))
                .collect(Collectors.toList());
    }
    
}
