package com.vadym.pet.project.model.clinicCreate.clinicCreateRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicCreateRequest {
    private String username;
    private String nameFirst;
    private String nameLast;
    private String emailAddress;
    private String password;
    private String locale;
    private Clinic clinic;
}