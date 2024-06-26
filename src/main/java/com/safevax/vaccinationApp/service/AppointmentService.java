package com.safevax.vaccinationApp.service;

import com.safevax.vaccinationApp.Dto.Reponse.AppointmentResponse;
import com.safevax.vaccinationApp.Dto.Reponse.PatientResponse;
import com.safevax.vaccinationApp.Enum.AppointmentStatus;
import com.safevax.vaccinationApp.exception.DoctorNotFoundException;
import com.safevax.vaccinationApp.exception.PatientNotFoundException;
import com.safevax.vaccinationApp.model.Appointment;
import com.safevax.vaccinationApp.model.Doctor;
import com.safevax.vaccinationApp.model.Patient;
import com.safevax.vaccinationApp.repository.AppointmentRepository;
import com.safevax.vaccinationApp.repository.DoctorRepository;
import com.safevax.vaccinationApp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

  @Autowired
    PatientRepository patientRepository;
  @Autowired
    DoctorRepository doctorRepository;
  @Autowired
    AppointmentRepository appointmentRepository;
    public AppointmentResponse bookAppointment(int patientId, int doctorId) {

        // check weather the patient record valid or not
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("invalid patient Id");
        }

        //check weather the doctor is available or not
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Docter not vailable");
        }

        Patient patient = patientOptional.get();
        Doctor doctor = doctorOptional.get();

        //Book the appointment doctor is available
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        //Model to dto response
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentId(savedAppointment.getAppointmentId());
        appointmentResponse.setDateOfAppointment(savedAppointment.getDateOfAppointment());
        appointmentResponse.setStatus(savedAppointment.getStatus());
        appointmentResponse.setDoctorName(savedAppointment.getDoctor().getName());

        Patient savedPatient = savedAppointment.getPatient();

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setVaccinated(savedPatient.isVaccinated());
        patientResponse.setEmailId(savedPatient.getEmailId());

        appointmentResponse.setPatientResponse(patientResponse);

        return appointmentResponse;

    }
}
