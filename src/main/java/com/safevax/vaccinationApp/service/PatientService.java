package com.safevax.vaccinationApp.service;

import com.safevax.vaccinationApp.exception.PatientNotFoundException;
import com.safevax.vaccinationApp.model.Patient;
import com.safevax.vaccinationApp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public Patient getPatient(int id) throws PatientNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid patient id");
        }
        Patient patient = patientOptional.get();
        return patient;
    }
    public void deletePatient(int patientId) {
        patientRepository.deleteById(patientId);
    }
}
