package com.automation.api.dto.requests;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dinudonney
 * @Date 08/07/22
 */
@Data
public class PetsDeleteRequestDTO {
    @JsonProperty("id")
    private String id;
}
