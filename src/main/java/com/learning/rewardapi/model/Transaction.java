package com.learning.rewardapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Transaction {
    
    private UUID id;
    private UUID customerId;
    private LocalDate date;
    private BigDecimal value;
    private BigDecimal rewardValue;

    public Transaction(@JsonProperty("id") UUID id, 
                       @JsonProperty("customerId") UUID customerId, 
                       @JsonProperty("date") String date, 
                       @JsonProperty("value") String value, 
                       @JsonProperty("rewardValue") String rewardValue){
        this.id = id;
        this.customerId = customerId;
        this.date = LocalDate.parse(date);
        this.value = BigDecimal.valueOf(Double.valueOf(value));
        this.rewardValue = BigDecimal.valueOf(Double.valueOf(rewardValue));
    }

    public Transaction(UUID id, UUID customerId, LocalDate date, BigDecimal value, BigDecimal rewardValue){
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.value = value;
        this.rewardValue = rewardValue;
    }

    public UUID getId(){
        return id;
    }

    public UUID getCustomerId(){
        return customerId;
    }

    public LocalDate getDate(){
        return date;
    }

    public BigDecimal getValue(){
        return value;
    }

    public BigDecimal getRewardValue(){
        return rewardValue;
    }

    public UUID setCustomerId(UUID customerId){
        this.customerId = customerId;
        return this.customerId;
    }

    public void setRewardValue(BigDecimal rewardValue){
        this.rewardValue = rewardValue;
    }

}
