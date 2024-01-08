import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    @DisplayName("Constructor test from User class")
    public void testTeacherConstructor() {

        String testFirstName = "First Name";
        String testName = "Name";
        String testCategory = "Teacher";
        int testAge = 19;
        long testID = 39202030;

        Teacher testTeacher = new Teacher(testFirstName, testName, testCategory, testAge, testID);

        assertEquals(testFirstName, testTeacher.getFirstName());
        assertEquals(testName, testTeacher.getLastName());
        assertEquals(testCategory, testTeacher.getCategory());
        assertEquals(testAge, testTeacher.getAge());
        assertEquals(testID, testTeacher.getID());

        assertEquals(testName + " " + testFirstName + " Credit: " + testTeacher.getCredit(), testTeacher.toString());

    }

}