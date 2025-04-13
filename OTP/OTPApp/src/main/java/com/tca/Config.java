package com.tca;

public class Config {

    // Sender Email Configuration
    public static final String HOST = "smtp.gmail.com";
    public static final String PORT = "587";
    public static final String SENDER_EMAIL = "senderMail@gmail.com"; //211
    public static final String PASSWORD = "qmxh xhus mixo vkra"; //your app password


    //Receiver email configuration
    public static final String userEmail = "receiverMail@gmail.com";


    //Database Configuration
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/quizkar?sslmode=disable";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root@123";

}
/*
DATABASE SCHEMA

CREATE TABLE otp_verification(
        user_id INT REFERENCES users(user_id),
otp VARCHAR(6),
expiry_timestamp TIMESTAMP,
PRIMARY KEY (user_id)
);
*/