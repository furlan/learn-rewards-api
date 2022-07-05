package com.learning.rewardapi.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

// Don't let Jackson serialize this any class that instantiate this interface
@JsonAutoDetect(fieldVisibility = Visibility.NONE)  
public interface Reward {
    public BigDecimal getRewardValue(BigDecimal transactionValue);
}
