package com.example.backclinic.service;

import com.example.backclinic.domain.Patient;
import com.example.backclinic.security.SecurityConfig;
import org.springframework.security.core.userdetails.User;
import com.example.backclinic.repository.PatientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class PatientService implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    private SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Patient patient = patientRepository.findByEmail(username);
        if(patient == null){
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(patient.getEmail()).password(patient.getPassword()).authorities("PATIENT").build();
        return user;
    }

    /*public User getUserNameByID(){

    }*/

    public void registerPatient(Patient patient){
        patientRepository.save(patient);
        securityConfig.userDetailsService(patient);
    }


}
