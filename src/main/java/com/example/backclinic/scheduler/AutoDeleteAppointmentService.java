package com.example.backclinic.scheduler;

import com.example.backclinic.domain.Appointment;
import com.example.backclinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AutoDeleteAppointmentService {

    private final AppointmentService appointmentService;

    @Scheduled(fixedRate = 600000)
    public void autoDelete(){
        Iterable<Appointment> appointmentList = appointmentService.getAllAppointments();
        List<Long> oldAppointmentsId = findOldAppointments(appointmentList);
        for(Long id:oldAppointmentsId)
            delete(id);
    }

    public List<Long> findOldAppointments(Iterable<Appointment> appointments){
        List<Long> listOfOldAppointments = new ArrayList<>();
        for(Appointment appointment: appointments){
            if(appointment.getDate().isBefore(LocalDateTime.now()))
                listOfOldAppointments.add(appointment.getId());
        }
        return listOfOldAppointments;
    }

    public void delete(Long appointmentId){
        appointmentService.deleteAppointmentById(appointmentId);
    }
}
