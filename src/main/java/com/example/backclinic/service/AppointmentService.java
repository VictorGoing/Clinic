package com.example.backclinic.service;

import com.example.backclinic.domain.Appointment;
import com.example.backclinic.domain.Doctor;
import com.example.backclinic.domain.Patient;
import com.example.backclinic.exception.AppointmentNotFound;
import com.example.backclinic.exception.ClinicUserNotFound;
import com.example.backclinic.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;


    public Appointment getAppointmentById(Long id) throws AppointmentNotFound {
        return appointmentRepository.findById(id).orElseThrow(AppointmentNotFound::new);
    }

    public Boolean checkAppointment(LocalDateTime dateTime, Long doctorId){
        List<Appointment> appointmentList = appointmentRepository.findAppointmentsByDoctorId(doctorId);
        if(appointmentList.size()>0)
            for(Appointment appointment:appointmentList){
                if(appointment.getDate().equals(dateTime))
                    return Boolean.FALSE;
            }
        return Boolean.TRUE;
    }

    public List<Appointment> getListOfAppointmentsById(List<Long> ids) {
        List<Appointment> collect = new ArrayList<>();
        for(Long id: ids){
            Appointment appointment = null;
            try {
                appointment = getAppointmentById(id);
            }catch (AppointmentNotFound e){
                e.printStackTrace();
            }
            collect.add(appointment);
        }
        return collect;
    }

    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getListOfAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findAppointmentsByPatientId(patientId);
    }

    public Iterable<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public void deleteAppointmentById(Long appointmentId){
        appointmentRepository.deleteById(appointmentId);
    }
}
