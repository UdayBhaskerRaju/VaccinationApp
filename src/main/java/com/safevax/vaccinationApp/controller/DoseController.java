package com.safevax.vaccinationApp.controller;

import com.safevax.vaccinationApp.Dto.Reponse.DoseResponse;
import com.safevax.vaccinationApp.Enum.VaccineBrand;
import com.safevax.vaccinationApp.exception.PatientNotFoundException;
import com.safevax.vaccinationApp.model.Dose;
import com.safevax.vaccinationApp.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;
    @PostMapping("/vaccinate")
    public DoseResponse addDose(@RequestParam("id") int patientId, @RequestParam("brand") VaccineBrand vaccineBrand) throws PatientNotFoundException {
        return doseService.addDose(patientId,vaccineBrand);
    }
}
