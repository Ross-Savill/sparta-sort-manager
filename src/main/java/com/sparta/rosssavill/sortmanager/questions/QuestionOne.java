package com.sparta.rosssavill.sortmanager.questions;

import java.util.Scanner;

public class QuestionOne {

    public int questionOneMethod() {
        Scanner scanner = new Scanner(System.in);
        int arrayNumber;
        System.out.print("\n How many random numbers would you like to sort? ");
        do {
            System.out.print("\n Please ensure your number is more than 1: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\n \"%s\" is not a valid number. Please try again: ", input);
            }
            arrayNumber = scanner.nextInt();
        } while (arrayNumber < 2);

        System.out.printf("\n You would like %d random numbers in your array.\n", arrayNumber);

        return arrayNumber;
    }
}
