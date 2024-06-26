package org.example;

import java.util.Scanner;

/**
 * Klasse, die den Input erzeugt
 */

public  class Input {

    Scanner sc;

    public Input(){
        sc = new Scanner(System.in);
        choice();
        sc.close();
    }

    private void choice(){
        System.out.println("-----------------------------");
        System.out.println("|   Validate password (1)   |");
        System.out.println("|   Generate password (2)   |");
        System.out.println("-----------------------------\n");
        System.out.print("Please enter your choice: ");
        String choice = sc.nextLine();

        switch (choice) {
             case "1":
                 inputValidatePassword();
                 break;
             case "2":
                 inputGeneratePassword();
                 break;
             default:
                 System.out.println("\nInvalid choice");
                 break;
        }

        sc.close();
    }

    private void inputValidatePassword(){
        System.out.print("\nPlease enter your password: ");
        String password = sc.nextLine();

        PasswordValidator validator = new PasswordValidator(password);

        System.out.println(validator.validate());
    }

    private void inputGeneratePassword(){
        PasswordValidator generator = new PasswordValidator();
        System.out.print("\nPlease enter a password  length (>= 8): ");


        try {
            int length = sc.nextInt();
            if (length < 8) {
                System.out.println("Your password should be at least 8 characters");
            } else {
                if (generator.generatePassword(length)) {
                    System.out.println("\nYour password was successfully generated");
                    System.out.println("Your generated Password: " + generator.getGeneratedPassword());
                }
            }
        }
        catch (Exception e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }
}
