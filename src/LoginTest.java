import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void testValidUsername() {
        assertTrue(Login.isValidUsernameEnhanced("ben_1"));
    }

    @Test
    void testInvalidUsername() {
        assertFalse(Login.isValidUsernameEnhanced("invalid_user"));
    }

    @Test

    void testValidCellphone() {
        assertTrue(Login.isValidCellphoneNumberInternational("+27812345678"));
    }

    @Test
    void testInvalidCellphone() {
        assertFalse(Login.isValidCellphoneNumberInternational("12345"));
    }

    @Test
    void testStrongPassword() {
        assertTrue(Login.isStrongPasswordEnhanced("Pass123!"));
    }

    @Test
    void testWeakPassword() {
        assertFalse(Login.isStrongPasswordEnhanced("weakness"));
    }
}

