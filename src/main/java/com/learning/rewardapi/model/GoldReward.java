package com.learning.rewardapi.model;

import java.math.BigDecimal;

public class GoldReward implements Reward {
    
    @Override
    public BigDecimal getRewardValue(BigDecimal transactionValue){
        // Reward rule calculation:
        // 2 points for every dollar spent over $100
        final BigDecimal twoPointLimit = new BigDecimal("100");
        // 1 point for every dollar spent over $50
        final BigDecimal onePointLimit = new BigDecimal("50");

        final BigDecimal rewardValue = new BigDecimal("0");

        if (transactionValue.compareTo(twoPointLimit) == 1) {
            //rewardValue += 2 * (transactionValue - twoPointLimit) + (1 * onePointLimit);
            rewardValue.add(transactionValue);
            rewardValue.subtract(twoPointLimit);
            rewardValue.multiply(BigDecimal.valueOf(2));
            rewardValue.add(onePointLimit);
        } else if (transactionValue.compareTo(onePointLimit) == 1){
           // rewardValue += 1 * (transactionValue - onePointLimit);
           rewardValue.add(transactionValue);
           rewardValue.subtract(onePointLimit);
        }
        
        return rewardValue;
        
    }
}
