package com.safevax.vaccinationApp.Dto.Reponse;

import com.safevax.vaccinationApp.Dto.Request.PatientRequest;
import com.safevax.vaccinationApp.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentResponse {

    private String appointmentId;
    private Date dateOfAppointment;
    private AppointmentStatus status;
    private PatientResponse patientResponse;

    private String doctorName;
}
