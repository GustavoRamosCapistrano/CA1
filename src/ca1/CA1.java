/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import static ca1.Checks.checkData;
import static ca1.Checks.workload;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * This program is a student information system. It includes methods for data
 * validation, file reading, writing and user interaction.
 *
 * This System contains a menu that allow you to choose between Standard
 * Operation and Add data via console.
 *
 * Standard Operation: Read a file from "Student.txt" and validate all the
 * Input, data that is approved are printed to a file "status.txt". Input that
 * is not valid will be showed a error message tho help fixing the information.
 *
 * Add data via Console: Ask for the input from user and validate all the data.
 * If that is correct are going to print to the file "status.txt". If not Valid
 * are going to show the error messages to help and fix the input. Use a loop to
 * place multiple Students information and check one by one. When done with the
 * input, just need to write "exit" and will close the program.
 *
 * Checks:
 *
 * Check for a First and Last name. First name can be only letters. Second name
 * can be letters and numbers. Also check if has a second name and must be
 * separated using a space " ".
 *
 * Check for a Number of classes, been between 1 and 8. After that check what
 * workload fit in eg. Very light, Light... Check for a Student number: Must be
 * bigger than 6 of length. Must start with 2 numbers and must be bigger than
 * 20. Fallowing for 2 or 3 letters. finishing with numbers that must be between
 * 1 and 200.
 *
 *
 * @author Gustavo Capistrano
 */
public class CA1 {
// main method to run the student system.

    public static void main(String[] args) {
        Scanner scMenu = new Scanner(System.in);
// menu to have options between Standart Operation e add via Console.
        OUTER:
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Standard Operation");
            System.out.println("2. Add data via Console");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            int choice = scMenu.nextInt();
            scMenu.nextLine();
            switch (choice) {
                case 1:
                    standardOperation();
                    break OUTER;
                case 2:
                    addDataViaConsole();
                    break OUTER;
                case 3:
                    System.out.println("Exiting program.");
                    break OUTER;
                default:
                    System.out.println("Invalid choice. please enter a valid option.");
                    break;
            }
        }
    }
// method to run the standard Operation.

    public static void standardOperation() {
        String studentsFile = "students.txt";
// opening scanner to read file.
        try ( Scanner sc = new Scanner(new FileReader(studentsFile));  BufferedWriter br = new BufferedWriter(new FileWriter("status.txt", true))) {
// loop to read all the file.
            while (sc.hasNextLine()) {
                String name = sc.nextLine();
                String numClassesString = sc.nextLine();
                String studentNumString = sc.nextLine();

                int numClasses = Integer.parseInt(numClassesString);
                //activating method to check data.
                boolean checkedData = checkData(numClasses, studentNumString, name);
                //writing to status.txt
                if (checkedData) {
                    br.write(studentNumString + " - " + name.split(" ")[1]);
                    br.newLine();
                    br.write(workload(numClasses));
                    br.newLine();
                    br.newLine(); // add double new line for better layout
                    System.out.println("Data is valid. Output saved to status.txt.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
// method to run Via console data.

    public static void addDataViaConsole() {
        Scanner scanner = new Scanner(System.in);

        // Collect user input for each student
        while (true) {
            System.out.println("Enter student details or type 'exit' to finish:");
            System.out.println("Full Name (First and Last name): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Number of Classes (1-8): ");
            int numClasses = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Student Number: ");
            String studentNumString = scanner.nextLine();

            // Validate and save data
            try {

                boolean checkedData = checkData(numClasses, studentNumString, name);
                if (checkedData) {
                    String statusFileName = "status.txt";
                    try ( FileWriter fileWriter = new FileWriter(statusFileName, true);  BufferedWriter writer = new BufferedWriter(fileWriter)) {

                        writer.write(studentNumString + " - " + name.split(" ")[1]);
                        writer.newLine();
                        writer.write(workload(numClasses));
                        writer.newLine();
                        writer.newLine(); // Add a double newline for better readability in the output file
                    }
                    System.out.println("Data is valid. Output saved to status.txt.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public static int indexOf(String input, String target) {
        return input.indexOf(target);
    }
}
