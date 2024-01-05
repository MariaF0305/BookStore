import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiteraryFictionTest {

    @Test
    public void testLiteraryFictionTestConstructor() {

        String testName = "Book Name";
        String testAuthor = "Book Author";
        String testGenre = "LiteraryFictionTest";
        double testPrice = 34.59;
        long testISBN = 939382929;

        LiteraryFiction testBook = new LiteraryFiction(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + " / " + testAuthor, testBook.toString());

    }
}