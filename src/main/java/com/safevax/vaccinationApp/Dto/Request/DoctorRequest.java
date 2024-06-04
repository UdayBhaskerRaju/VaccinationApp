package com.safevax.vaccinationApp.Dto.Request;

import com.safevax.vaccinationApp.Enum.Gender;
import com.safevax.vaccinationApp.Enum.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorRequest {
    private String name;
    private int age;
    private Gender gender;
    private Specialization specialization;
}
