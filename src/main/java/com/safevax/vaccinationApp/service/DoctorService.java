package com.safevax.vaccinationApp.service;

import com.safevax.vaccinationApp.exception.PatientNotFoundException;
import com.safevax.vaccinationApp.model.Doctor;
import com.safevax.vaccinationApp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "doctor added successfully";
    }
    public Doctor getDoctor(int id) throws PatientNotFoundException {
       Optional<Doctor> doctoroptional = doctorRepository.findById(id);
       if(doctoroptional.isEmpty()){
           throw new PatientNotFoundException("Invalid patient id");
       }
       Doctor doctor = doctoroptional.get();
       return doctor;
    }
}
