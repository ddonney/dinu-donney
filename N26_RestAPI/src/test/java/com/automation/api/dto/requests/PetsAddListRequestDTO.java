package com.automation.api.dto.requests;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author dinudonney
 * @Date 07/07/22
 */

@JsonPropertyOrder({
        "id",
        "name",
        "category",
        "photoUrls",
        "tags",
        "status"
})

@Data
public class PetsAddListRequestDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private HashMap <String,String> category;

    @JsonProperty("photoUrls")
    private ArrayList<String> photoUrls;

    @JsonProperty("tags")
    private ArrayList<HashMap<String,String> >tags;

    @JsonProperty("status")
    private String status;



}

