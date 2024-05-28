package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();

        PasswordValidator validator = new PasswordValidator(password);

        System.out.println(validator.validate());

        System.out.println("\nPlease enter a password  length (>= 8): ");
        int length = sc.nextInt();
        System.out.println("Your generated password: " + validator.generatePassword(length));
    }
}