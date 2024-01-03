import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    @Test
    @DisplayName("Constructor from BookLoan class")
    public void testBookLoanConstructor() {
        Student testUser = new Student("testFirstName", "testName", "Student", 19, 73939292);
        BookLoan bookLoan = new BookLoan(testUser);

        assertEquals(testUser, bookLoan.getUser());
        assertTrue(bookLoan.getListOfBooks().isEmpty());
    }
}