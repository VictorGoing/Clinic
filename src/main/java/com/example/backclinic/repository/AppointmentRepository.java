package com.example.backclinic.repository;

import com.example.backclinic.domain.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {

    @Override
    Optional<Appointment> findById(Long id);


    Boolean existsAppointmentById(Long id);

    List<Appointment> findAppointmentsByPatientId(Long patientId);

    List<Appointment> findAppointmentsByDoctorId(Long doctorId);
}
