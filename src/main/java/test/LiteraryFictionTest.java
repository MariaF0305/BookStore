package test;

import myapp.LiteraryFiction;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class LiteraryFictionTest {

    @Test
    @DisplayName("Constructor test from myapp.LiteraryFiction class")
    public void testLiteraryFictionTestConstructor() {

        String testName = "myapp.Book Name";
        String testAuthor = "myapp.Book Author";
        String testGenre = "test.LiteraryFictionTest";
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
