# Learning project - Rewards API

## Introduction

Learning project implementing API for this scenario: A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

## To-Do

- Update model diagram

## Services Available for version 1

### Insert a Customer

POST

### Return all Customers

GET: /customer

## Model

### Customer

### Transaction

### RewardGold

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).