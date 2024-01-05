import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrimeThrillerTest {

    @Test
    public void testCrimeThrillerTestConstructor() {

        String testName = "Book Name";
        String testAuthor = "Book Author";
        String testGenre = "CrimeThriller";
        double testPrice = 34.59;
        long testISBN = 939382929;

        CrimeThriller testBook = new CrimeThriller(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + " / " + testAuthor, testBook.toString());

    }
}