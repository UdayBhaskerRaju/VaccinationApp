package com.safevax.vaccinationApp.controller;

import com.safevax.vaccinationApp.Dto.Reponse.PatientResponse;
import com.safevax.vaccinationApp.Dto.Request.PatientRequest;
import com.safevax.vaccinationApp.exception.PatientNotFoundException;
import com.safevax.vaccinationApp.model.Patient;
import com.safevax.vaccinationApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/add-patient")
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest){
        try {
            PatientResponse patientResponse = patientService.addPatient(patientRequest);
            return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Invalid record",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-patient")
    public PatientResponse getPatient(@RequestParam("id") int id) throws PatientNotFoundException {
        return patientService.getPatient(id);
    }
}
