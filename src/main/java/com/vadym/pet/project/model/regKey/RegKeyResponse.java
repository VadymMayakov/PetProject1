package com.vadym.pet.project.model.regKey;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class RegKeyResponse {
    @JsonProperty("registrationKey")
    private String registrationKey;
    @JsonProperty("sentTo")
    private String sentTo;
    @JsonProperty("sentTs")
    @JsonIgnore
    private Long sentTs;
    @JsonProperty("regKeyStatus")
    private String regKeyStatus;
    @JsonProperty("type")
    private String type;
}
