import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CreditCardValidatorTest {

    private CreditCardValidator.CreditCardOperations creditCardOperations;

    @BeforeEach
    void setUp() {
        creditCardOperations = new CreditCardValidator.CreditCardOperations();
    }

    @DisplayName("Testing")
    @Test
    void validateCreditCard() {
        // Valid cases
        assertEquals("valid", creditCardOperations.validateCreditCard("012850003580200"));
        System.out.println("Test 1.....Passed");
        assertEquals("valid", creditCardOperations.validateCreditCard("12345678903555"));
        System.out.println("Test 2.....Passed");
        assertEquals("valid", creditCardOperations.validateCreditCard("1802909582961827"));
        System.out.println("Test 3.....Passed");

        // Invalid cases
        assertEquals("invalid", creditCardOperations.validateCreditCard("124987653456849"));
        System.out.println("Test 4.....Passed");
        assertEquals("invalid", creditCardOperations.validateCreditCard("00000000000000"));
        System.out.println("Test 5.....Passed");
        assertEquals("invalid", creditCardOperations.validateCreditCard("abcsjkj12345jndfk"));
        System.out.println("Test 6.....Passed");
        assertEquals("invalid", creditCardOperations.validateCreditCard("34"));
        System.out.println("Test 7.....Passed");
    }

}