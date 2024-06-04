package com.safevax.vaccinationApp.Dto.Reponse;

import com.safevax.vaccinationApp.Enum.VaccineBrand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoseResponse {

    private String serialNumber; //UUID
    private VaccineBrand vaccineBrand;
    private Date deteOfVacccination;
    private PatientResponse patientResponse;
}
