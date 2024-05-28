package org.example;

import java.util.Scanner;

/**
 * Klasse, die den Input, sowie eine Instanz des Validators erzeugt
 */

public  class Input {

    public Input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();

        PasswordValidator validator = new PasswordValidator(password);

        System.out.println(validator.validate());


        System.out.println("\nPlease enter a password  length (>= 8): ");

        try {
            int length = sc.nextInt();
            if (length < 8) {
                System.out.println("Your password should be at least 8 characters");
            } else {
                if (validator.generatePassword(length)) {
                    System.out.println("Your password was successfully generated");
                    System.out.println("Your generated Password: " + validator.getGeneratedPassword());
                }
            }
        }
        catch (Exception e) {
            System.err.println("Invalid input: " + e.getMessage());
        }

        sc.close();
    }
}
