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
        String firstName = name.substring(0, indexOf(" "));
        return (firstName.matches("[a-zA-Z]+"));
    }
     public static boolean checkSecondName(String name) {
        String SecondName = name.substring(indexOf(" "));
        return (SecondName.matches("[A-Z0-9]+"));
    }
     public static boolean checkNumClasses(int numClasses){
         return numClasses >= 1 && numClasses <= 8;
             
     }
     public static boolean checkstudentNumLength(String studentNum){
         return studentNum.length() >= 6;
     }
     public static boolean checkstudentNum(String studentNum){
         String firstTwoChars = studentNum.substring(0, 2);
         
         try{
             int firstTwoDigits = Integer.parseInt(firstTwoChars);
             return firstTwoDigits >20;
         } catch(Exception e) {
             System.out.println("The first two characters are not numeric or not bigger than 20");             
         }
     }
    public static void main(String[] args) {
        
        
        String students = "students.txt";
         try{
            Scanner sc = new Scanner(new FileReader(students));
            
            String name = sc.nextLine();
            String numClasses = sc.nextLine();
            String studentNum = sc.nextLine();
            
            
            System.out.println("Line 1: " + name);
            System.out.println("Line 2: " + numClasses);
            System.out.println("Line 3: " + studentNum);
            
            
            sc.close();
           
            } catch (Exception e) {
            System.out.println(e);
            }
         
         
        }

    private static int indexOf(String a_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    }
    

