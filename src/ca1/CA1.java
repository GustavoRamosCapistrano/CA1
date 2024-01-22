/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        if (studentNum.length() < 6) {
            System.out.println("Invalid Student ID: length needs to be more than 6 ");
            return false;
        }

            try {
                String firstTwoChars = studentNum.substring(0, 2);
                int firstTwoDigits = Integer.parseInt(firstTwoChars);
                
                if (firstTwoDigits < 20) {
                    System.out.println("Invalid Student ID: first two digits must be 20 or higher.");
                    return false;
                }
                    
                    char thirdChar = studentNum.charAt(2);
                    char forthChar = studentNum.charAt(3);

                    if (!(Character.isLetter(thirdChar) && Character.isLetter(forthChar))) {
                        System.out.println("Invalid Student ID: 3rd and 4th characters must be letters");
                        return false;
                    }
                        
                        
                        char fifthChar = studentNum.charAt(4);
                        if (Character.isLetter(fifthChar)) {
                            int remainingDigits = Integer.parseInt(studentNum.substring(5));
                            return remainingDigits >= 1 && remainingDigits <= 0200;
                        }else if(Character.isDigit(fifthChar)){
                            int remainingDigits = Integer.parseInt(studentNum.substring(4));
                            return remainingDigits >= 1 && remainingDigits <= 0200;   
                        }else{
                            System.out.println("Invalid student ID: 5th character mus be letter or number.");
                            return false;
                        }
            } catch (Exception e) {
                System.out.println("Invalid student ID: " + e);
                return false;
            }
    }
    
        public static String workload(int numClasses) {
            if (numClasses == 1){
                return "Vary Light";
            } else if(numClasses == 2){
                return "Light";
            }else if (numClasses >=3 && numClasses <= 5){
                return "Part Time";
            }else if (numClasses >= 6){
                return "Full Time";
            }else{
                return "Number of classes out of Range.";
            } 
    }

    public static void main(String[] args) {
            Scanner scMenu = new Scanner(System.in);
            
            while (true){
                System.out.println("Menu: ");
                System.out.println("1. Standart Operation");
                System.out.println("2. add data via Console");
                System.out.println("3. Exit");
                System.out.println("Choose an option: ");
                
                int choice = scMenu.nextInt();
                scMenu.nextLine();
                
                if (choice == 1){
                    standardOperation();
                    break;
                }else if (choice == 2){
                    addDataViaConsole();
                    break;
                }else if (choice == 3){
                    System.out.println("Exiting program.");
                    break;
                }else{
                    System.out.println("Invalid choice. please enter a valid option.");
                }
            }
    }
            private static void standardOperation(){
              String studentsFile = "students.txt";
             try  (Scanner sc = new Scanner(new FileReader(studentsFile))){
                 while (sc.hasNextLine()){
                    String name = sc.nextLine();
                    String numClassesString = sc.nextLine();
                    String studentNumString = sc.nextLine();
                    
                    try{
                        int numClasses = Integer.parseInt(numClassesString);
                    
                        if(checkFirstName(name) && checkSecondName(name) && checkNumClasses(numClasses) && checkStudentNum(studentNumString)){
                            String statusFile = "status.txt";
                            try(FileWriter fileWriter = new FileWriter(statusFile, true);
                                BufferedWriter br = new BufferedWriter(fileWriter)){
                                
                                br.write(studentNumString + " - " + name.split(" ")[1]);
                                br.write(workload(numClasses));
                                br.newLine();
                                br.newLine();// add double new line for better layout
                            }
                            System.out.println("Data is valid. Output saved to status.txt.");
                    }
                    
                    }catch (NumberFormatException e){
                        System.out.println("Invalid number of classes: " + e.getMessage());
                    }
                 }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                 
             }
            }
             private static void addDataViaConsole(){
                 
             }
             private static int indexOf(String input, String target){
                 return input.indexOf(target);
             }
}