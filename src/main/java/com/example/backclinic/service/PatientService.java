package com.example.backclinic.service;

import com.example.backclinic.domain.ClinicUser;
import com.example.backclinic.domain.Patient;
import com.example.backclinic.exception.ClinicUserNotFound;
import com.example.backclinic.repository.PatientRepository;
//import com.example.backclinic.security.SecurityConfig;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientService {//implements UserDetailsService {


    private final PatientRepository patientRepository;

    //private final SecurityConfig securityConfig;

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Patient patient = patientRepository.findByEmail(username);
        if(patient == null){
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(patient.getEmail()).password(patient.getPassword()).authorities("PATIENT").build();
        return user;
    }*/


    public Patient getPatientById(Long patientId) throws ClinicUserNotFound{
        return patientRepository.findById(patientId).orElseThrow(ClinicUserNotFound::new);}

    public void registerPatient(Patient patient){
        //securityConfig.userDetailsService(patient);
        patientRepository.save(patient);
    }

    public Patient getPatientByEmail(String email) throws ClinicUserNotFound {
        return patientRepository.findByEmail(email).orElseThrow(ClinicUserNotFound::new);
    }

    public void deletePatientById(Long patientId){
        patientRepository.deleteById(patientId);
    }


    /*public Patient loginPatient(String email, String password) throws ClinicUserNotFound{
        ClinicUser clinicUser = patientRepository.findByEmail(email);
        if(clinicUser.getPassword().equals(password)){
            //securityConfig.userDetailsService(clinicUser);
            Patient patient = patientRepository.findByEmail(email);
            return patient;
        }
        throw new ClinicUserNotFound();
    }*/

}

