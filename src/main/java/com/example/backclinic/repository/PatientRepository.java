package com.example.backclinic.repository;

import com.example.backclinic.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {
    Patient findByEmail(String email);
}
