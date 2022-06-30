package com.example.backclinic.repository;

import com.example.backclinic.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
