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

    public static boolean checkStudentNum(String studentNum) {
        if (studentNum.length() >= 6) {
            
        }else{
            System.out.println("Student ID: length need to be 6.");

            try {
                String firstTwoChars = studentNum.substring(0, 2);
                int firstTwoDigits = Integer.parseInt(firstTwoChars);
                if (firstTwoDigits > 20) {
                    
                    char thirdChar = studentNum.charAt(2);
                    char forthChar = studentNum.charAt(3);

                    if (Character.isLetter(thirdChar) && Character.isLetter(forthChar)) {
                        
                        
                        char fifthChar = studentNum.charAt(4);
                        if (Character.isLetter(fifthChar)) {
                            int remainingDigits = Integer.parseInt(studentNum.substring(5));
                            return remainingDigits >= 1 && remainingDigits <= 0200;
                        }else if(Character.isDigit(fifthChar)){
                            int remainingDigits = Integer.parseInt(studentNum.substring(4));
                            return remainingDigits >= 1 && remainingDigits <= 0200;
                           
                        }else{
                            System.out.println("Invalid student ID: first and second must be a number and bigger than 20.");
                        
                        }
                        
                    }else{
                        System.out.println("Invalid student ID: 3th and 4th character must be letter.");
                    }
                }else{
                    System.out.println("Invalid student ID: 5th character mus be letter or number.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return false;
    }
        public static String workload(int numClasses) {
            String workload;
            if (numClasses >=6){
                workload = "full Time";
            } else if(numClasses >=3 && numClasses < 5){
                workload = "Part Time";
            }else if (numClasses == 2){
                workload = "Light";
            }else if (numClasses == 1){
                workload = "Very Light";
            }
           return workload;     
    }

    public static void main(String[] args) {

        String studentsFile = "students.txt";
        try {
            Scanner sc = new Scanner(new FileReader(studentsFile));

            String name = sc.nextLine();
            String numClasses = sc.nextLine();
            String studentNumString = sc.nextLine();
            try{
            int studentNum = Integer.parseInt(studentNumString);
            
            System.out.println("Line 1: " + name);
            System.out.println("Line 2: " + numClasses);
            System.out.println("Line 3: " + studentNumString);
            }catch(Exception e){
                System.out.println(e);
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
