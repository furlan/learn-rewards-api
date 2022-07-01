package com.learning.rewardapi.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    
    private final UUID id;
    
    @NotBlank
    private final String name;

    public Customer(@JsonProperty("id") UUID id, 
                    @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
