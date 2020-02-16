package com.vadym.pet.project.model.clinicCreate.clinicCreateRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicRegistrationKey {

    private String registrationKey;
}
