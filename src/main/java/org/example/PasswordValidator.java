package org.example;

public class PasswordValidator {
    String password;
    String[] badPasswordList = {"Test123*", "Pa$$wort1"};

    public PasswordValidator(String password) {
        this.password = password;
    }

    public String validate() {
        if (minEightChars(password) && upperAndLowercase(password) && (!passwordBadMatch(password)) && hasSpecial(password))
            return "Your password is valide";
        else
            return "Your password is invalide";
    }

    public String generatePassword(){
        return "Not implemented yet";
    }

    private boolean minEightChars(String password) {
        return password.length() >= 8;
    }

    private boolean upperAndLowercase(String password) {
        return isUppercase(password) && isLowercase(password);
    }

    private boolean isUppercase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean isLowercase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasSpecial(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    private boolean passwordBadMatch(String password) {
        for (String badPassword : badPasswordList)
            return password.equals(badPassword);
        return false;
    }
}
