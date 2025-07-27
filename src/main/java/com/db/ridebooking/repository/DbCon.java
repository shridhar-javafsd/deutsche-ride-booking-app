package com.db.ridebooking.repository;


import java.sql.*;

public class DbCon {

    private static final String JDBC_URL = "jdbc:h2:mem:testdb"; // For H2
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public void initialize() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String createTable = """
                CREATE TABLE IF NOT EXISTS rides (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    source VARCHAR(50),
                    destination VARCHAR(50),
                    fare DOUBLE
                )
            """;

            stmt.execute(createTable);
            System.out.println("✅ Table 'rides' created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveRide(String source, String destination, double fare) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO rides (source, destination, fare) VALUES (?, ?, ?)")) {

            ps.setString(1, source);
            ps.setString(2, destination);
            ps.setDouble(3, fare);

            ps.executeUpdate();
            System.out.println("🚗 Ride saved.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllRides() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM rides")) {

            System.out.println("📋 All Rides:");
            while (rs.next()) {
                System.out.printf("ID: %d | %s ➡ %s | ₹%.2f%n",
                        rs.getInt("id"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getDouble("fare"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
