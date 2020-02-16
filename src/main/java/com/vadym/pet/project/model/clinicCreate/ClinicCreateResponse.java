package com.vadym.pet.project.model.clinicCreate;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class ClinicCreateResponse {
    @JsonProperty("value")
    private String value;

}

