package com.safevax.vaccinationApp.service;

import com.safevax.vaccinationApp.Dto.Reponse.DoctorResponse;
import com.safevax.vaccinationApp.Dto.Request.DoctorRequest;
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
    public DoctorResponse addDoctor(DoctorRequest doctorRequest) {

        Doctor doctor = new Doctor();
        doctor.setName(doctorRequest.getName());
        doctor.setAge(doctorRequest.getAge());
        doctor.setGender(doctorRequest.getGender());
        doctor.setSpecialization(doctorRequest.getSpecialization());

        Doctor savedDoctor = doctorRepository.save(doctor);

        DoctorResponse doctorResponse = new DoctorResponse();

        doctorResponse.setName(savedDoctor.getName());
        doctorResponse.setAge(savedDoctor.getAge());
        doctorResponse.setSpecialization(savedDoctor.getSpecialization());
        return doctorResponse;
    }
    public DoctorResponse getDoctor(int id) throws PatientNotFoundException {
       Optional<Doctor> doctoroptional = doctorRepository.findById(id);
       if(doctoroptional.isEmpty()){
           throw new PatientNotFoundException("Invalid patient id");
       }
        Doctor savedDoctor = doctoroptional.get();
        DoctorResponse doctorResponse = new DoctorResponse();
        doctorResponse.setName(savedDoctor.getName());
        doctorResponse.setAge(savedDoctor.getAge());
        doctorResponse.setSpecialization(savedDoctor.getSpecialization());
        return doctorResponse;
    }
}
