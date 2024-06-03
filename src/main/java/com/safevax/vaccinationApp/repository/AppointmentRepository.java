package com.safevax.vaccinationApp.repository;

import com.safevax.vaccinationApp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
