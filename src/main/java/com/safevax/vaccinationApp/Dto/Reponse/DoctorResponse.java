package com.safevax.vaccinationApp.Dto.Reponse;

import com.safevax.vaccinationApp.Enum.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorResponse {
    private String name;
    private int age;
    private Specialization specialization;
}
