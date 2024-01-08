import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class RegularCustomerTest {

    @Test
    @DisplayName("Constructor test from User class")
    public void testUserConstructor() {

        String testFirstName = "First Name";
        String testName = "Name";
        String testCategory = "Regular Customer";
        int testAge = 19;
        long testID = 39202030;

        RegularCustomer testRegularCustomer = new RegularCustomer(testFirstName, testName, testCategory, testAge, testID);

        assertEquals(testFirstName, testRegularCustomer.getFirstName());
        assertEquals(testName, testRegularCustomer.getLastName());
        assertEquals(testCategory, testRegularCustomer.getCategory());
        assertEquals(testAge, testRegularCustomer.getAge());
        assertEquals(testID, testRegularCustomer.getID());

        assertEquals(testName + " " + testFirstName + " Credit: " + testRegularCustomer.getCredit(), testRegularCustomer.toString());
    }

}