package com.db.ridebooking.service;

import com.db.ridebooking.model.Ride;

import java.util.ArrayList;
import java.util.List;

public class RideService {
    private List<Ride> rideList = new ArrayList<>();
    private FareCalculator fareCalculator;
    private PaymentService paymentService;

    public RideService(FareCalculator fareCalculator, PaymentService paymentService) {
        this.fareCalculator = fareCalculator;
        this.paymentService = paymentService;
    }

    public void bookRide(String riderName, String from, String to) {
        double fare = fareCalculator.calculateFare(from, to);
        Ride ride = new Ride(riderName, from, to, fare);
        rideList.add(ride);
        paymentService.processPayment(riderName, fare);
        System.out.println("Ride booked: " + ride);
    }

    public List<Ride> getAllRides() {
        return rideList;
    }
}



//package com.db.ridebooking.service;
//
//import com.db.ridebooking.model.Ride;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RideService {
//    private List<Ride> rideList = new ArrayList<>();
//
//    public void bookRide(String riderName, String from, String to) {
//        double fare = calculateFare(from, to);
//        Ride ride = new Ride(riderName, from, to, fare);
//        rideList.add(ride);
//        System.out.println("Ride booked: " + ride);
//    }
//
//    public List<Ride> getAllRides() {
//        return rideList;
//    }
//
//    public double calculateFare(String from, String to) {
//        int kms = 10;
//        return kms * 20;
//    }
//}
