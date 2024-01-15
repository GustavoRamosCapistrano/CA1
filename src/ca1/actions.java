/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author grc29
 */
public class actions {
    
        String students = "students.txt";
        
        public void reader() {
        try{
            Scanner sc = new Scanner(new File(students));
            
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
