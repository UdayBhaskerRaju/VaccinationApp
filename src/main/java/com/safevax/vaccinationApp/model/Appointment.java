package com.safevax.vaccinationApp.model;

import com.safevax.vaccinationApp.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String appointmentId;
    @CreationTimestamp
    private Date dateOfAppointment;
    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus status;
    @ManyToOne // doctor had many appointments
    @JoinColumn // appointment table contain foreign key doctor_Id
    Doctor doctor;

    @OneToOne //one Appointment has one patient
    @JoinColumn //Appointment table is child table
    Patient patient;
}
