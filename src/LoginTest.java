import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void testValidUsername() {
        assertTrue(Login.isValidUsernameEnhanced("kyl_1"));
    }

    @Test
    void testInvalidUsername() {
        assertFalse(Login.isValidUsernameEnhanced("kyle!!!!!!"));
    }

    @Test

    void testValidCellphone() {
        assertTrue(Login.isValidCellphoneNumberInternational("+27838968976"));
    }

    @Test
    void testInvalidCellphone() {
        assertFalse(Login.isValidCellphoneNumberInternational("08966553"));
    }

    @Test
    void testStrongPassword() {
        assertTrue(Login.isStrongPasswordEnhanced("Ch&&sec@ke99!"));
    }

    @Test
    void testWeakPassword() {
        assertFalse(Login.isStrongPasswordEnhanced("password"));
    }
}

