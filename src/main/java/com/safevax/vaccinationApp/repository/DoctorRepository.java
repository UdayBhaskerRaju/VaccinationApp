package com.safevax.vaccinationApp.repository;

import com.safevax.vaccinationApp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
