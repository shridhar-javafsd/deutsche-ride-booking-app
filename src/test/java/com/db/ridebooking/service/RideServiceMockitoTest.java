package com.db.ridebooking.service;

import com.db.ridebooking.model.Ride;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RideServiceMockitoTest {

    FareCalculator fareCalculator;
    PaymentService paymentService;
    RideService rideService;

    @BeforeEach
    void setUp() {
        fareCalculator = mock(FareCalculator.class);
        paymentService = mock(PaymentService.class);
        rideService = new RideService(fareCalculator, paymentService);
    }

    @Test
    void testBookRide_WithMocks() {
        when(fareCalculator.calculateFare("X", "Y")).thenReturn(150.0);

        rideService.bookRide("Ravi", "X", "Y");

        List<Ride> rides = rideService.getAllRides();
        assertEquals(1, rides.size());
        assertEquals("Ravi", rides.get(0).getRiderName());
        assertEquals(150.0, rides.get(0).getFare());

        verify(fareCalculator).calculateFare("X", "Y");
        verify(paymentService).processPayment("Ravi", 150.0);
    }
}
