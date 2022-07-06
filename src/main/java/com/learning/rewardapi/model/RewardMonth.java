package com.learning.rewardapi.model;

import java.math.BigDecimal;
import java.util.UUID;

public class RewardMonth {

    private UUID customerId;
    private Integer month;
    private BigDecimal total;

    // If I want to show the transactions in response
    // private List<Transaction> transactions

    public RewardMonth(UUID customerId, Integer month, BigDecimal total) {
        this.customerId = customerId;
        this.month = month;
        this.total = total;
    }

    public UUID getCustomerId(){
        return customerId;
    }

    public Integer getMonth(){
        return month;
    }
    
    public BigDecimal getTotal(){
        return total;
    }
}
