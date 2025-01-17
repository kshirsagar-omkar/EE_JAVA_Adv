package com.tca;

import com.tca.controller.StudentController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. Get Student by ID");
            System.out.println("3. Get All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    StudentController.addStudent();
                    break;
                case 2:
                    StudentController.getStudentByRollNumber();
                    break;
                case 3:
                    StudentController.getAllStudents();
                    break;
                case 4:
                    StudentController.updateStudent();
                    break;
                case 5:
                    StudentController.deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}