package com.tca;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String userEmail = "user@gmail.com";
        Integer userId = 4;

        //1. Generate the otp
        Integer otpLength = 6;
        String otp = OTPGenerator.generateOTP(otpLength);

        //2. Set the otp expiry (e.g., 5 Minutes from now)
        ZonedDateTime kolkataTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        Timestamp expiryTimestamp = Timestamp.from(kolkataTime.plusMinutes(5).toInstant());

        //3. Save the otp to database
        OTPRepository otpRepo = new OTPRepository();
        otpRepo.saveOrUpdateOTP(userId, otp, expiryTimestamp);


        //4. Send the otp via mail
        EmailService emailService = new EmailService();
        String subject = "Your One-Time-Password (OTP) for QuizKar";
        String body = "Your OTP is: " + otp + "\nNote: It is valid for the next 5 minutes.";

        try{
            emailService.sendEmail(userEmail, subject, body);
            System.out.println("OTP sent to " + userEmail);
        }
        catch(Exception e){
            System.out.println("Failed to send OTP email.");
            e.printStackTrace();
            return;
        }

        //5. Accept OTP from the user via terminal
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The OTP: ");
        String inputOTP = sc.nextLine().trim();

        if(otpRepo.validateOTP(userId, inputOTP)){
            System.out.println("OTP is Valid!");
        }
        else {
            System.out.println("Invalid OTP or OTP has expired.");
        }

        sc.close();
    }
}