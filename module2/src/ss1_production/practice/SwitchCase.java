package ss1_production.practice;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your grade: ");
        String userInput = input.next();
        char grade = userInput.charAt(0);
        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
                System.out.println("Great!");
            case 'C':
            case 'D':
                System.out.println("Well done!");
                break;
            case 'F':
                System.out.println("Sorry, you failed.");
                break;
            default:
                System.out.println("Error! Invalid grade.");
        }
    }
}
