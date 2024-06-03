package com.safevax.vaccinationApp.service;

import com.safevax.vaccinationApp.Enum.VaccineBrand;
import com.safevax.vaccinationApp.exception.PatientNotFoundException;
import com.safevax.vaccinationApp.model.Dose;
import com.safevax.vaccinationApp.model.Patient;
import com.safevax.vaccinationApp.repository.DoseRepository;
import com.safevax.vaccinationApp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    PatientRepository patientRepository;
    public Dose addDose(int patientId,VaccineBrand vaccineBrand) throws PatientNotFoundException {
        //check weather the patient id is valid or not
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid patient id");
        }
        Patient patient = patientOptional.get();

        //check if the patient is already vaccinated or not
        if(patient.isVaccinated()){
            throw new RuntimeException("patient is already vaccinated");
        }
        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
        dose.setPatient(patient);
        patientRepository.save(patient);
        return doseRepository.save(dose);

    }
}
