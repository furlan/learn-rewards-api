package com.learning.rewardapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    
    private UUID id;
    private UUID customerId;
    private LocalDateTime date;
    private BigDecimal value;
    private BigDecimal rewardValue;

    public Transaction(UUID id, UUID customerId, LocalDateTime date, BigDecimal value){
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.value = value;
    }

    public UUID getId(){
        return id;
    }

    public UUID getCustomerId(){
        return customerId;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public BigDecimal getValue(){
        return value;
    }

    public BigDecimal getRewardValue(){
        return rewardValue;
    }

    public void setRewardValue(BigDecimal rewardValue){
        this.rewardValue = rewardValue;
    }

}
