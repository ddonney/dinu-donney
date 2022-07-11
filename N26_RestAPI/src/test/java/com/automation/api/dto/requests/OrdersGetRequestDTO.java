package com.automation.api.dto.requests;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * @author dinudonney
 * @Date 11/07/22
 */

@JsonPropertyOrder({
        "orderId"
})

@Data
public class OrdersGetRequestDTO {

    @JsonProperty("orderId")
    private String orderId;
}
