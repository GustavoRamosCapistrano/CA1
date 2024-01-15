/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.util.Scanner;
import java.io.File;
/**
 *
 * @author Gustavo Capistrano
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            Scanner sc = new Scanner(new File("students.txt"));
            
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String line3 = sc.nextLine();
            
            System.out.println("Line 1: " + line1);
            System.out.println("Line 2: " + line2);
            System.out.println("Line 3: " + line3);
            
            
            sc.close();
            } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    }
    

