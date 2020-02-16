package com.vadym.pet.project.model.regKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegKeyRequest {
    private String CREATED_FOR;
    private String CREATED_BY;
    private String TYPE;
}
