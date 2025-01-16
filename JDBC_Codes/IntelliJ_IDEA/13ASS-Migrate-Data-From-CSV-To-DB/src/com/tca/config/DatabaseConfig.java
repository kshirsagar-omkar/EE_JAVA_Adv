package com.tca.config;

public class DatabaseConfig {

        //Utility Class
        //We are not creating the object of this class so restrict the user from creating obj of this class
        //Sence all Data member's are Class Type(Static )
        private DatabaseConfig(){}

        public final static String URL = "jdbc:postgresql://localhost:5432/ee_java_db?sslmode=disable";
        public final static String USER = "root";
        public final static String PASSWORD = "root@123";
        public final static String DRIVER = "org.postgresql.Driver";
    }
