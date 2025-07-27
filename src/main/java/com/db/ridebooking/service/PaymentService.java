package com.db.ridebooking.service;

public class PaymentService {

    public void processPayment(String riderName, double amount) {
        System.out.println("Processing payment of ₹" + amount + " for " + riderName);
    }
}
