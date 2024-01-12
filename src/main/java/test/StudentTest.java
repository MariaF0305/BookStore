package test;

import myapp.Student;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    @DisplayName("Constructor test from myapp.User class")
    public void testUserConstructor() {

        String testFirstName = "First Name";
        String testName = "Name";
        String testCategory = "myapp.Student";
        int testAge = 19;
        long testID = 39202030;

        Student testStudent = new Student(testFirstName, testName, testCategory, testAge, testID);

        assertEquals(testFirstName, testStudent.getFirstName());
        assertEquals(testName, testStudent.getLastName());
        assertEquals(testCategory, testStudent.getCategory());
        assertEquals(testAge, testStudent.getAge());
        assertEquals(testID, testStudent.getID());

        assertEquals(testName + " " + testFirstName + " Credit: " + testStudent.getCredit(), testStudent.toString());
    }

}