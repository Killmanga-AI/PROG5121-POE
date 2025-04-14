import javax.swing.JOptionPane; // For creating simple dialog boxes
import java.util.regex.Matcher; // For regular expression matching
import java.util.regex.Pattern; // For defining regular expression patterns

public class Login {

    public static void main(String[] args) {
        String username;
        boolean usernameValid = false;

        // Loop until a valid username is entered
        while (!usernameValid) {
            // Prompt the user to enter their username using an input dialog
            username = JOptionPane.showInputDialog(null, "Enter your username (max 5 chars, one '_'):");

            // Check if the user provided input (didn't cancel)
            if (username == null) {
                // Inform the user if they cancelled the input dialog for username
                JOptionPane.showMessageDialog(null, "Username input cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return; // Exit the main method if the user cancelled username input
            }

            // Validate the entered username
            if (isValidUsernameEnhanced(username)) {
                // Display a success message if the username is valid
                JOptionPane.showMessageDialog(null, "Username successfully captured!");
                usernameValid = true; // Set the flag to exit the username input loop
            } else {
                // Display an error message and prompt the user to try again
                JOptionPane.showMessageDialog(null, "Invalid username format. Please try again.", "Username Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String cellphoneNumber;
        boolean cellphoneValid = false;

        // Loop until a valid cellphone number is entered
        while (!cellphoneValid) {
            // Prompt the user to enter their cellphone number using an input dialog
            cellphoneNumber = JOptionPane.showInputDialog(null, "Enter your cellphone number (starting with country code, >= 9 digits):");

            // Check if the user provided input (didn't cancel)
            if (cellphoneNumber == null) {
                // Inform the user if they cancelled the input dialog for cellphone number
                JOptionPane.showMessageDialog(null, "Cellphone number input cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return; // Exit the main method if the user cancelled cellphone number input
            }

            // Validate the entered cellphone number
            if (isValidCellphoneNumberInternational(cellphoneNumber)) {
                // Display a success message if the cellphone number is valid
                JOptionPane.showMessageDialog(null, "Cellphone number successfully added!");
                cellphoneValid = true; // Set the flag to exit the cellphone number input loop
            } else {
                // Display an error message and prompt the user to try again
                JOptionPane.showMessageDialog(null, "Invalid cellphone number format. Please try again.", "Cellphone Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String password;
        boolean passwordValid = false;

        // Loop until a valid password is entered
        while (!passwordValid) {
            // Prompt the user to enter their password using an input dialog
            password = JOptionPane.showInputDialog(null, "Enter your password (>= 8 chars, upper, lower, digit, special):");

            // Check if the user provided input (didn't cancel)
            if (password == null) {
                // Inform the user if they cancelled the input dialog for password
                JOptionPane.showMessageDialog(null, "Password input cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return; // Exit the main method if the user cancelled password input
            }

            // Validate the entered password
            if (isStrongPasswordEnhanced(password)) {
                // Display a success message if the password is valid
                JOptionPane.showMessageDialog(null, "Password successfully captured!");
                // In a real application, you would hash the password here for security.
                JOptionPane.showMessageDialog(null, "All data validated successfully (password not displayed for security).", "Success", JOptionPane.INFORMATION_MESSAGE);
                passwordValid = true; // Set the flag to exit the password input loop
            } else {
                // Display an error message and prompt the user to try again
                JOptionPane.showMessageDialog(null, "Password does not meet the complexity requirements. Please try again.", "Password Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Enhanced username validation: checks if the username contains exactly one underscore
     * and is at most 5 characters long.
     *
     * @param username The username string to validate.
     * @return true if the username is valid according to the criteria, false otherwise.
     */
    public static boolean isValidUsernameEnhanced(String username) {
        // Count the number of underscore characters in the username
        long underscoreCount = username.chars().filter(ch -> ch == '_').count();
        // Return true if there is exactly one underscore and the length is not more than 5
        return underscoreCount == 1 && username.length() <= 5;
    }

    /**
     * Enhanced cellphone number validation: checks if the number starts with a digit or '+'
     * (for a country code) and has a minimum length of 8 digits. This is a basic check.
     *
     * @param cellphoneNumber The cellphone number string to validate.
     * @return true if the cellphone number format is potentially valid, false otherwise.
     */
    //Regex pattern inspired by ChatGPT (OpenAI,2024)
    public static boolean isValidCellphoneNumberInternational(String cellphoneNumber) {
        // Check if the string is not null or empty, matches the pattern of digits and/or '+', and has at least 8 characters
        return cellphoneNumber != null && cellphoneNumber.matches("^[0-9+]+$") && cellphoneNumber.length() >= 9;
    }

    /**
     * Enhanced password strength check: verifies if the password has at least 8 characters
     * and contains at least one uppercase letter, one lowercase letter, one digit, and one special character.
     *
     * @param password The password string to validate.
     * @return true if the password meets all the strength requirements, false otherwise.
     */
    public static boolean isStrongPasswordEnhanced(String password) {
        // Check for null or length less than 8
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Iterate through each character of the password
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else {
                // Use a regular expression to check for special characters (anything not alphanumeric)
                Pattern specialPattern = Pattern.compile("[^a-zA-Z0-9]");
                Matcher specialMatcher = specialPattern.matcher(String.valueOf(c));
                if (specialMatcher.find()) {
                    hasSpecial = true;
                }
            }
        }
        // Return true only if all the required character types are present
        return hasUpper && hasLower && hasDigit && hasSpecial;

    }
}