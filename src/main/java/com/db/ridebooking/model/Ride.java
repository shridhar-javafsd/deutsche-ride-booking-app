package com.db.ridebooking.model;

public class Ride {
    private String riderName;
    private String from;
    private String to;
    private double fare;

    public Ride(String riderName, String from, String to, double fare) {
        this.riderName = riderName;
        this.from = from;
        this.to = to;
        this.fare = fare;
    }

    public String getRiderName() {
        return riderName;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return riderName + " booked a ride from " + from + " to " + to + " for ₹" + fare;
    }
}
