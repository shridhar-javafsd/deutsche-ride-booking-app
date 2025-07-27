package com.db.ridebooking.repository;

import com.db.ridebooking.model.Ride;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RideRepository {

    public Ride saveRide(Ride ride) {
        String sql = "INSERT INTO rides (rider_name, source, destination, fare) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbUtil.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ride.getRiderName());
            stmt.setString(2, ride.getFrom());
            stmt.setString(3, ride.getTo());
            stmt.setDouble(4, ride.getFare());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ride;
    }

    public List<Ride> getAllRides() {
        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM rides";

        try (Connection conn = DbUtil.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ride ride = new Ride(
                        rs.getString("rider_name"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getDouble("fare")
                );
                rides.add(ride);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rides;
    }
}
