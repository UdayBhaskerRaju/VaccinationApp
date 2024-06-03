package com.safevax.vaccinationApp.model;

import com.safevax.vaccinationApp.Enum.VaccineBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String serialNumber; //UUID
    @Enumerated(value = EnumType.STRING)
    private VaccineBrand vaccineBrand;
    @CreationTimestamp
    private Date deteOfVacccination;

    @OneToOne // One patient has one dose
    @JoinColumn // dose table had foreign key patient_Id
    Patient patient;
}
