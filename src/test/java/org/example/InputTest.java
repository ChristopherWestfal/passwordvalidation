package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Bei diesen Tests wird die Konsolenausgabe einer Methode erfasst und überprüft, ob sie den erwarteten Wert beinhält.
 * Dafür wird eine Eingabe simuliert und in einem ByteArrayInputStream gespeichert. Im nächsten Schritt wird in einem
 * ByteArrayOutputsteam alles gespeichert, was innerhalb der Methode an ein System.out.* gesendet wird.
 * Über die toString()-Methode kann der Output in einen String umgewandelt werden und über das assertTrue
 * mit dem erwarteten Output auf Gleichheit überprüft werden.
 */

class InputTest {

    @Test
    public void inputValidatePassword_shouldValid_forValidPassword() {
        // Zu simulierende Eingabe
        String simulatedInput = "1\nHall0Wel!\n";

        // Eingabe über System.in wird Simuliert
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Jede Ausgabe die an System.out. geschickt wird, wird in den ByteArrayOutputStream geschrieben
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        new Input();


        String output = outputStream.toString();
        assertTrue(output.contains("Your password is valide"));
    }

    @Test
    public void inputValidatePassword_shouldInvalid_forInvalidPassword() {
        String simulatedInput = "1\nHall0Welt\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        new Input();

        String output = outputStream.toString();
        assertTrue(output.contains("Your password is invalide"));
    }

    @Test
    public void inputValidateGenerator_shouldValid_for9() {
        String simulatedInput = "2\n9\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        new Input();

        String output = outputStream.toString();
        assertTrue(output.contains("Your password was successfully generated"));
    }

    @Test
    public void inputChoice_shouldInvalid_for3() {
        String simulatedInput = "3\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        new Input();

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid choice"));
    }
}