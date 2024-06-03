package com.safevax.vaccinationApp.controller;

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
    public String addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
    @GetMapping("/get-doctor")
    public Doctor getDoctor(@RequestParam("id") int id) throws PatientNotFoundException {
        return doctorService.getDoctor(id);
    }
}
