package com.example.backclinic.service;

import com.example.backclinic.domain.Doctor;
import com.example.backclinic.repository.DoctorRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor getDoctorById(Long id){return doctorRepository.findDoctorById(id);}

    public List<Doctor> getAllDoctors(){return doctorRepository.findAll();}

    public void registerDoctor(Doctor doctor){doctorRepository.save(doctor);}
}
