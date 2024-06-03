package com.safevax.vaccinationApp.controller;

import com.safevax.vaccinationApp.model.Appointment;
import com.safevax.vaccinationApp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/Book")
    public ResponseEntity bookAppointment(@RequestParam("pId") int patientId,@RequestParam("dId") int doctorId){
        try {
           Appointment appointmentBooked = appointmentService.bookAppointment(patientId, doctorId);
           return new ResponseEntity<>(appointmentBooked, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
