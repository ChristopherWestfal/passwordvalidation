package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    PasswordValidator validator;
    String expectedValid = "Your password is valide";
    String expectedInvalid = "Your password is invalide";

    @Test
    void validate_shouldReturnTrue_forValidPassword() {
        validator = new PasswordValidator("Hall*Welt1");
        assertEquals(expectedValid, validator.validate());
    }

    @Test
    void validate_shouldReturnFalse_forUnderEightChars() {
        validator = new PasswordValidator("hall*");
        assertEquals(expectedInvalid, validator.validate());
    }

    @Test
    void validate_shouldReturnFalse_forNoDigits() {
        validator = new PasswordValidator("hall*welt");
        assertEquals(expectedInvalid, validator.validate());
    }

    @Test
    void validate_shouldReturnFalse_forNoUppercase() {
        validator = new PasswordValidator("hall*welt1");
        assertEquals(expectedInvalid, validator.validate());
    }

    @Test
    void validate_shouldReturnFalse_forNoLowercase() {
        validator = new PasswordValidator("HALL*WELT1");
        assertEquals(expectedInvalid, validator.validate());
    }

    @Test
    void validate_shouldReturnFalse_forNoSpecialCharacter() {
        validator = new PasswordValidator("HalloWelt1");
        assertEquals(expectedInvalid, validator.validate());
    }

    @Test
    void validate_shouldReturnFalse_forBadMatch() {
        validator = new PasswordValidator("Test123*");
        assertEquals(expectedInvalid, validator.validate());
    }

    @Test
    void generatePassword_shouldReturnTrue_forValidPasswordlength() {
        validator = new PasswordValidator();
        assertTrue(validator.generatePassword(8));
    }
}