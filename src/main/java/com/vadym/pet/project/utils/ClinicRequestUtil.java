package com.vadym.pet.project.utils;

import com.vadym.pet.project.model.clinicCreate.clinicCreateRequest.Clinic;
import com.vadym.pet.project.model.clinicCreate.clinicCreateRequest.ClinicCreateRequest;
import com.vadym.pet.project.model.clinicCreate.clinicCreateRequest.ClinicRegistrationKey;

public class ClinicRequestUtil {
    public static ClinicCreateRequest generateRequest(String registrationKey) {
        Clinic clinic = new Clinic();

        clinic.setZip("CA9 3HX");
        clinic.setName("mjhfgthj");
        clinic.setCountryCode("GB");
        clinic.setClinicRegistrationKey(new ClinicRegistrationKey(registrationKey));

        ClinicCreateRequest clinicCreateRequest = ClinicCreateRequest.builder()
                .username(NameGenerator.generateUserName())
                .nameFirst("NF" + NameGenerator.randomInt())
                .nameLast("NL" + NameGenerator.randomInt())
                .emailAddress("qavalid@gmail.com")
                .password("blabla123")
                .locale("en_GB")
                .clinic(clinic)
                .build();
        System.out.println("Username: " + clinicCreateRequest.getUsername() + "\n" + "Password: " + clinicCreateRequest.getPassword());//♥♥♥♥
        return clinicCreateRequest;
    }
}
