package ceilingfanapplication;

import java.util.Scanner;

/**
 * @date 21-11-2020
 * @author Anthony Loughlin
 */
public class CeilingFanApplication {

    public static void main(String[] args) {
        System.out.println(String.format("Ceiling Fan"));
        int speed = 0;
        boolean reversed = false;
        Scanner sc = new Scanner(System.in);
        while (true) {
            //Prints a formatted message based on the values currently contained in the speed and reversed variables
            System.out.println(String.format("%nSpeed:%s Direction:%s%n", speed == 0 ? "Off" : speed, reversed ? "Reversed" : "Standard"));
            int cordChoice = validateInput(sc, "Pull cord 1 or 2: ");
            if (cordChoice == 1) {
                switch (speed) {
                    case 3:
                        speed = 0;
                        break;
                    default:
                        speed += 1;
                        break;
                }
            } else if (cordChoice == 2) {
                reversed = !reversed;
            }
        }
    }

    //Validates the user selection throwing an error message if a problem occurs and re-prompts the user until the correct conditions are met
    public static int validateInput(Scanner sc, String prompt) {
        boolean isValidInt = false;
        int i = 0;
        while (isValidInt == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                if(i == 1 || i == 2){
                  sc.nextLine();
                  break;
                }               
            }   
            else{
                sc.next();  
            }
            System.out.println(String.format("%nInvalid selection. Please choose either option 1 or 2.%n"));
            sc.nextLine();          
        }
        return i;
    }
}
