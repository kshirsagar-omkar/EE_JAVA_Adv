package com.tca;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class OTPRepository {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/quizkar?sslmode=disable";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root@123";

    //Save or update the otp into database
    public void saveOrUpdateOTP(Integer userId, String otp, Timestamp expiryTimestamp) {
        String sql = "INSERT INTO otp_verification (user_id, otp, expiry_timestamp) " +
                "VALUES (?, ?, ?) " +
                "ON CONFLICT (user_id) DO UPDATE SET " +
                "otp = EXCLUDED.otp, " +
                "expiry_timestamp = EXCLUDED.expiry_timestamp";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, otp);
            ps.setTimestamp(3, expiryTimestamp);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public Boolean validateOTP(Integer userId, String inputOTP){
        String sql = "SELECT otp, expiry_timestamp FROM otp_verification WHERE user_id = ? ORDER BY expiry_timestamp DESC LIMIT 1";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String savedOTP = rs.getString("otp");
                Timestamp expiryTimestamp = rs.getTimestamp("expiry_timestamp");

                // Get the current time in Asia/Kolkata time zone
                Timestamp now = Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant());

                //Check if otp matches and still valid (not expired)
                if(savedOTP.equals(inputOTP) && now.before(expiryTimestamp)){
                    return true;
                }

            }
        }catch (SQLException e) {
            e.printStackTrace();
            // Handle error
        }
        return false;


    }


}
