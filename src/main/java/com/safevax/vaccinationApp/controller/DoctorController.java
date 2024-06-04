package com.safevax.vaccinationApp.controller;

import com.safevax.vaccinationApp.Dto.Reponse.DoctorResponse;
import com.safevax.vaccinationApp.Dto.Request.DoctorRequest;
import com.safevax.vaccinationApp.exception.PatientNotFoundException;
import com.safevax.vaccinationApp.model.Doctor;
import com.safevax.vaccinationApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    // Adding doctor details to database
    @PostMapping("/add")
    public DoctorResponse addDoctor(@RequestBody DoctorRequest doctorRequest){
        return doctorService.addDoctor(doctorRequest);
    }
    @GetMapping("/get-doctor")
    public DoctorResponse getDoctor(@RequestParam("id") int id) throws PatientNotFoundException {
        return doctorService.getDoctor(id);
    }
}
