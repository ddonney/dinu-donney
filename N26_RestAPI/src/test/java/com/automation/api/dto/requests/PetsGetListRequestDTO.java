package com.automation.api.dto.requests;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * @author dinudonney
 * @Date 07/07/22
 */
@JsonPropertyOrder({
        "Status"
})

@Data
public class PetsGetListRequestDTO {
    @JsonProperty("Status")
    private String Status;

    @JsonProperty("Tags")
    private String Tags;

    @JsonProperty("ID")
    private String ID;
}
