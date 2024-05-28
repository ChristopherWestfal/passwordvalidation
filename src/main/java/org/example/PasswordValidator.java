package org.example;

import java.security.SecureRandom;

public class PasswordValidator {
    // Zeichen die für ein valides Passwort jeweils mindestens 1x gebraucht werden
    private final static String ALPHABETUPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String ALPHABETLOWER = "abcdefghijklmnopqrstuvwxyz";
    private final static String NUMBERS = "0123456789";
    private final static String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/~`";

    private String password;
    private final static String[] badPasswordList = {"Test123*", "Pa$$wort1"};
    private String generatedPassword = "";

    private final static String VALIDE = "Your password is valide";
    private final static String INVALIDE = "Your password is invalide";

    // Standardkonstruktor
    public PasswordValidator(){
        this.password = "";
    }
    // Konstruktor der Klasse mit Übergabeparameter
    public PasswordValidator(String password) {
        this.password = password;
    }

    // öffentliche Methode zur Validierung des eingegebenen Passwortes
    public String validate() {
        if (minEightChars(password) && hasDigit(password) && upperAndLowercase(password) && (passwordMatch(password)) && hasSpecial(password)) {
            password = "";
            return VALIDE;
        }
        else{
            password = "";
            return INVALIDE;
        }
    }

    // Öffentliche Methode zum Generieren eines Passwortes, dass den Vorgaben entspricht
    // ruft die überladene, private validate()-Methode intern auf
    public boolean generatePassword(int length){
        SecureRandom sRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        String allChars = ALPHABETUPPER + ALPHABETLOWER + NUMBERS + SPECIAL_CHARACTERS;

        // erzeugt solange Passwörter der übergebenen Länge, bis ein valides Passwort erzeugt wurde
        // und gibt es zurück
        while(!(!generatedPassword.isEmpty() && !generatedPassword.equals(INVALIDE))) {
            for (int i = 0; i < length; i++) {
                int index = sRandom.nextInt(allChars.length());
                sb.append(allChars.charAt(index));
            }

            generatedPassword = validate(sb.toString());
        }
        generatedPassword = sb.toString();
        return true;
    }

    // prüft, ob Passwortlänge größer oder gleich 8 ist
    private boolean minEightChars(String password) {
        return password.length() >= 8;
    }

    // prüft, ob Passwort Zahlen enthält
    private boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    // prüft, ob Passwort groß- und kleingeschriebene Buchstaben enthält
    private boolean upperAndLowercase(String password) {
        return isUppercase(password) && isLowercase(password);
    }

    private boolean isUppercase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean isLowercase(String password) {
        return password.matches(".*[a-z].*");
    }

    // prüft, ob ein Sonderzeichen vorhanden ist
    private boolean hasSpecial(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    // prüft, ob das eingegebene Passwort ain der Liste mit schwachen Passwörtern eingetragen ist
    private boolean passwordMatch(String password) {
        for (String badPassword : badPasswordList)
            return !password.equals(badPassword);
        return true;
    }

    // private, überladene Methode zur Passwortvalidierung
    private String validate(String password) {
        if (minEightChars(password) && hasDigit(password) && upperAndLowercase(password) && (passwordMatch(password)) && hasSpecial(password))
            return VALIDE;
        else
            return INVALIDE;
    }

    // gibt das erzeugte Passwort zurück
    public String getGeneratedPassword() {
        return generatedPassword;
    }
}
