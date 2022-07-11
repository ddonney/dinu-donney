package com.automation.api.dto.requests;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dinudonney
 * @Date 11/07/22
 */

@Data
public class OrdersDeleteRequesrDTO {
    @JsonProperty("id")
    private String id;
}
