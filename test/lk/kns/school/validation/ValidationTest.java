package lk.kns.school.validation;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidationTest {

    public ValidationTest() {
    }

    @Test
    public void testEmailRegex() {
        String regex = Validation.EMAIL.validate();
        assertTrue("Valid email should pass", "student@school.com".matches(regex));
        assertFalse("Invalid email should fail", "bad-email".matches(regex));
    }

    @Test
    public void testMobileRegex() {
        String regex = Validation.MOBILE.validate();
        assertTrue("Valid mobile should pass", "0752345678".matches(regex));
        assertFalse("Mobile without 0 prefix should fail", "712345678".matches(regex));
    }

    @Test
    public void testPasswordRegex() {
        String regex = Validation.PASSWORD.validate();
        assertTrue("Strong password should pass", "Pass123".matches(regex));
        assertFalse("Short password should fail", "Pas1".matches(regex));
    }
}