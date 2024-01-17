/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Gustavo Capistrano
 */
public class CA1 {

    public static boolean checkFirstName(String name) {
        String firstName = name.substring(0, indexOf(name, " "));
        return (firstName.matches("[a-zA-Z]+"));
    }

    public static boolean checkSecondName(String name) {
        String SecondName = name.substring(indexOf(name, " ") + 1);
        return (SecondName.matches("[A-Z0-9]+"));
    }

    public static boolean checkNumClasses(int numClasses) {
        return numClasses >= 1 && numClasses <= 8;

    }

    public static boolean checkstudentNum(String studentNum) {
        if (studentNum.length() >= 6) {
            String firstTwoChars = studentNum.substring(0, 2);

            try {
                int firstTwoDigits = Integer.parseInt(firstTwoChars);
                if (firstTwoDigits > 20) {
                    char thirdChar = studentNum.charAt(2);
                    char forthChar = studentNum.charAt(3);

                    if (Character.isLetter(thirdChar) && Character.isLetter(forthChar)) {
                        int currentIndex = 4;
                        
                        char fifthChar = studentNum.charAt(currentIndex);
                        if (Character.isLetter(fifthChar)) {
                            currentIndex++;
                            while (currentIndex < studentNum.length()) {
                                char currentChar = studentNum.charAt(currentIndex);
                                if (!Character.isDigit(currentChar)) {
                                    return false;
                                }
                                currentIndex++;
                            }
                            int remainingDigits = Integer.parseInt(studentNum.substring(4, currentIndex));
                            return remainingDigits >= 1 && remainingDigits <= 0200;
                        }
                    }
                }

            } catch (Exception e) {
            }

        }
        return false;
    }

    public static void main(String[] args) {

        String studentsFile = "students.txt";
        try {
            Scanner sc = new Scanner(new FileReader(studentsFile));

            String name = sc.nextLine();
            String numClasses = sc.nextLine();
            String studentNumString = sc.nextLine();

            System.out.println("Line 1: " + name);
            System.out.println("Line 2: " + numClasses);
            System.out.println("Line 3: " + studentNumString);
            int studentNum = Integer.parseInt(studentNumString);
            
            if (checkNumClasses(studentNum)) {
                System.out.println("valid Student Number.");
            } else {
                System.out.println("Invalid student number");
            }
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static int indexOf(String input, String target) {
        return input.indexOf(target);
    }

}
