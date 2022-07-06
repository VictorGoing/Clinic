package com.example.backclinic.repository;

import com.example.backclinic.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {


    Optional<Patient> findByEmail(String email);

    @Override
    Optional<Patient> findById(Long patientId);

    @Override
    void deleteById(Long patientId);
}
