package com.db.ridebooking;

import com.db.ridebooking.model.Ride;
import com.db.ridebooking.repository.RideRepository;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        RideRepository repository = new RideRepository();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter details:");
        System.out.print("Enter rider name: ");
        String name = scanner.nextLine();

        System.out.print("Enter source: ");
        String from = scanner.nextLine();

        System.out.print("Enter destination: ");
        String to = scanner.nextLine();

        System.out.print("Enter fare: ");
        double fare = scanner.nextDouble();

        Ride ride = new Ride(name, from, to, fare);
        Ride savedRide = repository.saveRide(ride);
        System.out.println(savedRide);

        System.out.println("All rides data:");
        List<Ride> rides = repository.getAllRides();
        for (Ride r : rides) {
            System.out.println(r);
        }
    }
}


//package com.db.ridebooking;
//
//import com.db.ridebooking.service.FareCalculator;
//import com.db.ridebooking.service.PaymentService;
//import com.db.ridebooking.service.RideService;
//
//public class App {
//    public static void main(String[] args) {
//        FareCalculator fareCalculator = new FareCalculator();
//        PaymentService paymentService = new PaymentService();
//        RideService rideService = new RideService(fareCalculator, paymentService);
//
//        rideService.bookRide("Sonu", "Gachibowli", "Paradise");
//        rideService.bookRide("Monu", "Banjara Hills", "Hitech City");
//
//        System.out.println("All booked rides:");
//        rideService.getAllRides().forEach(System.out::println);
//    }
//}
