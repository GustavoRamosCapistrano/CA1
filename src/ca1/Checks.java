/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 * This Java class is to contains all the methods for the System checks.
 *
 *  * Checks: Check for a First and Last name. First name can be only letters,
 * Second name can be letters and numbers. Also check if has a second name and
 * must be separated using a space " ". Check for a Number of classes, been
 * between 1 and 8. After that check what workload fit in eg. Very light, Light
 * ... Check for a Student number: Must be bigger than 6 of length. Must start
 * with 2 numbers and must be bigger than 20. Fallowing for 2 or 3 letters.
 * finishing with numbers that must be between 1 and 200.
 *
 *
 * @author grc29
 */
public class Checks {
    //validation for the first name (only letters).

    public static boolean checkFirstName(String name) {
        //slicing the first name and checking for letters
        String firstName = name.substring(0, indexOf(name, " "));
        return (firstName.matches("[a-zA-Z]+"));
    }
// validation for the seconf name (letters and numbers).

    public static boolean checkSecondName(String name) {
        //slicing the second name after " " to check for letter and numbers.
        String SecondName = name.substring(indexOf(name, " ") + 1);
        return (SecondName.matches("[a-zA-Z0-9]+"));
    }
// check for the input of classes to meet the range allowed.

    public static boolean checkNumClasses(int numClasses) {
        return numClasses >= 1 && numClasses <= 8;

    }
// check for correct length for the Student number.

    public static boolean checkStudentNumLength(String studentNumString) {
        return studentNumString.length() >= 6;

    }
    //Validates that the first two characters of the student number are numbers and greater than or equal to 20. 

    public static boolean checkTwoFirstNum(String studentNumString) {
        String firstTwoChars = studentNumString.substring(0, 2);
        int firstTwoDigits = Integer.parseInt(firstTwoChars);
        return firstTwoDigits >= 20;
    }
//Validates that the third and fourth characters of the student number are letters.

    public static boolean checkStudentNumLetters(String studentNumString) {
        if (studentNumString.length() >= 4) {
            char thirdChar = studentNumString.charAt(2);
            char forthChar = studentNumString.charAt(3);

            return Character.isLetter(thirdChar) && Character.isLetter(forthChar);
        } else {
            return false;
        }
    }

    /**
     * Validates the structure of the student number, ensuring the fifth
     * character is a letter or number, and the remaining characters (if any)
     * are digits, with a value less than or equal to 200
     *
     * @param studentNumString.
     * @return
     */
    public static boolean checkStudentNum(String studentNumString) {
        char fifthChar = studentNumString.charAt(4);

        if (Character.isLetter(fifthChar)) {
            // If the fifth character is a letter, check all following digits
            try {
                int remainingDigits = Integer.parseInt(studentNumString.substring(5));
                return remainingDigits <= 200;
            } catch (NumberFormatException e) {
                System.out.println("Invalid student ID: Following characters must be digits.");
                return false;
            }
        } else if (Character.isDigit(fifthChar)) {
            // If the fifth character is a digit, check the slice of digits
            try {
                int remainingDigits = Integer.parseInt(studentNumString.substring(4));
                return remainingDigits <= 200;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkhasSecondName(String name) {
        // Encontrar o índice do primeiro espaço
        int spaceIndex = name.indexOf(" ");

        // Verificar se um espaço foi encontrado e se há algo depois do espaço
        return spaceIndex > 0 && spaceIndex < name.length() - 1;
    }
//determines the workload based on the classes number.

    public static String workload(int numClasses) {
        if (numClasses == 1) {
            return "Vary Light";
        } else if (numClasses == 2) {
            return "Light";
        } else if (numClasses >= 3 && numClasses <= 5) {
            return "Part Time";
        } else if (numClasses >= 6) {
            return "Full Time";
        } else {
            return "Number of classes out of Range.";
        }
    }
// validates all data for students and display helpfull mesages to know were are the error.

    public static boolean checkData(int numClasses, String studentNumString, String name) {
        if (!checkhasSecondName(name)) {
            System.out.println("Must have Space and second name after");
            return false;
        }
        if (!checkFirstName(name)) {
            System.out.println("First name may just have letters.");
            return false;
        }
        if (!checkSecondName(name)) {
            System.out.println("Second name must have only letters or numbers.");
            return false;
        }
        if (!checkNumClasses(numClasses)) {
            System.out.println("Number of classes must be between.");
            return false;
        }
        if (!checkStudentNumLength(studentNumString)) {
            System.out.println("Student Number has a incorrect length(6 or more).");
            return false;
        }
        if (!checkTwoFirstNum(studentNumString)) {
            System.out.println("Student Number: 1st and 2nd characters must be numbers and bigger than 20.");
            return false;
        }
        if (!checkStudentNumLetters(studentNumString)) {
            System.out.println("Student Number: 3rd and 4th characters must be letters.");
        }
        if (!checkStudentNum(studentNumString)) {
            System.out.println("5th caracter need to be a letter or number, final number must be between a range of 1 and 200.");
            return false;
        }

        return true;

    }

    public static int indexOf(String input, String target) {
        return input.indexOf(target);
    }

}
