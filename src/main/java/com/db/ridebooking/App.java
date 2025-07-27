package com.db.ridebooking;

import com.db.ridebooking.service.FareCalculator;
import com.db.ridebooking.service.PaymentService;
import com.db.ridebooking.service.RideService;

public class App {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();
        PaymentService paymentService = new PaymentService();
        RideService rideService = new RideService(fareCalculator, paymentService);

        rideService.bookRide("Sonu", "Gachibowli", "Paradise");
        rideService.bookRide("Monu", "Banjara Hills", "Hitech City");

        System.out.println("All booked rides:");
        rideService.getAllRides().forEach(System.out::println);
    }
}
