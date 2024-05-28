package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();

        PasswordValidator validator = new PasswordValidator(password);

        System.out.println(validator.validate());
        System.out.println("\nYour generated password: " + validator.generatePassword());
    }
}