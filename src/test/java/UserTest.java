import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("Constructor test from User class")
    public void testUserConstructor() {

        String testFirstName = "First Name";
        String testName = "Name";
        String testCategory = "Student";
        int testAge = 19;
        long testID = 39202030;
        String testUserType = "Student";

        Student testUser = new Student(testFirstName, testName, testCategory, testAge, testID);

        assertEquals(testFirstName, testUser.getFirstName());
        assertEquals(testName, testUser.getName());
        assertEquals(testCategory, testUser.getCategory());
        assertEquals(testAge, testUser.getAge());
        assertEquals(testID, testUser.getID());

        assertEquals(testName + " " + testFirstName, testUser.toString());
    }
}