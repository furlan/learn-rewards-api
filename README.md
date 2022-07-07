# Rewards API (Learning project)

## Introduction

Learning project implementing API for this scenario: A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

## To-Do

- Update model diagram
- Implement security
- Implement persistence using Postgress DB.

## Services Available for version 1

### Customer

| Action | Path                        | Description                                       |
| ------ | --------------------------- | ------------------------------------------------- |
| GET    | /customer                   | Get all customers                                 |
| GET    | /customer/{id}              | Get one customer                                  |
| PUT    | /customer/{id}              | Change one customer                               |
| POST   | /customer/{id}              | Insert one customer                               |
| DELETE | /customer/{id}              | Delete one customer                               |
| POST   | /customer/{id}/transactions | Insert one transaction for a specific customer    |
| GET    | /customer/{id}/transactions | Get all transactions for a specific customer      |
| GET    | /customer/{id}/rewardmonths | Get all Rewards per month for a specific customer | 


## Reward Model

The reward is associated to the customer and customers could have different types of rewards rules.

A class is responsible to implement the reward with the specific rule.

### Reward Response

This an example of reward response:

```JSON
[
    {
        "customerId": "3bd1ad9a-80f8-4d98-b3fd-7a7ee55cd299",
        "month": 5,
        "total": 1190.0
    },
    {
        "customerId": "3bd1ad9a-80f8-4d98-b3fd-7a7ee55cd299",
        "month": 6,
        "total": 12850.0
    },
    {
        "customerId": "3bd1ad9a-80f8-4d98-b3fd-7a7ee55cd299",
        "month": 7,
        "total": 852.0
    }
]
```

### Gold Reward

Gold Reward will reward customers following this rule:

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).