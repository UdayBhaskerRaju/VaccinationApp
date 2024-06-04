package com.safevax.vaccinationApp.service;

import com.safevax.vaccinationApp.Dto.Reponse.PatientResponse;
import com.safevax.vaccinationApp.Dto.Request.PatientRequest;
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

    public PatientResponse addPatient(PatientRequest patientRequest) {

        //request dto -> model/entity
        Patient patient = new Patient();
        patient.setVaccinated(false);
        patient.setAge(patientRequest.getAge());
        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setEmailId(patientRequest.getEmailId());

        Patient savedPatient = patientRepository.save(patient);

        //convert model response dto
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setEmailId(savedPatient.getEmailId());
        patientResponse.setVaccinated(savedPatient.isVaccinated());

        return patientResponse;
    }

    public PatientResponse getPatient(int id) throws PatientNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid patient id");
        }
        Patient patient = patientOptional.get();
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(patient.getName());
        patientResponse.setEmailId(patient.getEmailId());
        patientResponse.setVaccinated(patient.isVaccinated());

        return patientResponse;
    }
}
