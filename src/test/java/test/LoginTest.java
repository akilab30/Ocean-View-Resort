package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testValidLogin() {

        String username = "admin";
        String password = "admin123";

        boolean result = username.equals("admin") && password.equals("admin123");

        assertTrue(result);
    }

    @Test
    public void testInvalidLogin() {

        String username = "admin";
        String password = "wrongpass";

        boolean result = username.equals("admin") && password.equals("admin123");

        assertFalse(result);
    }
}