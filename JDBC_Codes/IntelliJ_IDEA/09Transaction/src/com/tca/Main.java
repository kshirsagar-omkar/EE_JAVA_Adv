package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public final static String URL = "jdbc:postgresql://localhost:5432/ee_java_db?sslmode=disable";
    public final static String USER = "root";
    public final static String PASSWORD = "root@123";
    public final static String DRIVER = "org.postgresql.Driver";


    public static Connection conn = null;
    public static PreparedStatement ps1 = null;
    public static PreparedStatement ps2 = null;

    public static void main(String[] args) {


        Integer senderAccNo = 101;
        Integer receiverAccNo = 104;
        Double amountToBeTransfer = 500.0;

        if( transferMoney( senderAccNo, receiverAccNo, amountToBeTransfer ) ){
            System.out.println("Transaction Successful!!");
        }
        else {
            System.out.println("Transaction Failed!!!");
        }

    }




    @SuppressWarnings("CallToPrintStackTrace")
    public static Boolean transferMoney(Integer sender, Integer receiver, Double amount){


        try{

            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            conn.setAutoCommit(false);
            //Transaction Code


            ps1 = conn.prepareStatement("UPDATE account SET balance = balance - ? WHERE acc_no = ?");
            ps1.setDouble(1,amount);
            ps1.setInt(2,sender);
            if(ps1.executeUpdate() == 0){
                throw new SQLException("Record Not Found For Sender Account Number: " + sender);
            }

//            Integer.parseInt("abc");

            ps2 = conn.prepareStatement("UPDATE account SET balance = balance + ? WHERE acc_no = ?");
            ps2.setDouble(1, amount);
            ps2.setInt(2, receiver);
            if(ps2.executeUpdate() == 0){
                throw new SQLException("Record Not Found For Receiver Account Number: " + receiver);
            }

            conn.commit();


            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("--------------TRANSACTION ROLLBACK--------------");
                e.printStackTrace();
            }

            return false;
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }



}