package com.db.ridebooking.service;

import com.db.ridebooking.model.Ride;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RideServiceTest {

    RideService rideService;

    @BeforeEach
    void setUp() {
        rideService = new RideService(new FareCalculator(), new PaymentService());
    }

    @Test
    void testBookRide() {
        rideService.bookRide("Sonu", "A", "B");
        List<Ride> rides = rideService.getAllRides();
        assertEquals(1, rides.size());
        assertEquals("Sonu", rides.get(0).getRiderName());
    }

    @Test
    void testGetAllRides_Multiple() {
        rideService.bookRide("Sonu", "A", "B");
        rideService.bookRide("Monu", "C", "D");
        List<Ride> rides = rideService.getAllRides();
        assertEquals(2, rides.size());
    }
}
