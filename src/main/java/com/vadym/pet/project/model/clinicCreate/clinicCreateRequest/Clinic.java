package com.vadym.pet.project.model.clinicCreate.clinicCreateRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {

    private String name;
    private String countryCode;
    private String zip;
    private ClinicRegistrationKey clinicRegistrationKey;
}

