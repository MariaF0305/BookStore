package test;

import myapp.BookLoan;
import myapp.Student;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class BookLoanTest {
    @Test
    @DisplayName("Constructor test from myapp.BookLoan class")
    public void testBookLoanConstructor() {
        Student testUser = new Student("testFirstName", "testName", "myapp.Student", 19, 73939292);
        BookLoan bookLoan = new BookLoan(testUser);

        assertEquals(testUser, bookLoan.getUser());
        assertTrue(bookLoan.getListOfBooks().isEmpty());
    }
}