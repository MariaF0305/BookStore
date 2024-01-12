package test;

import myapp.HistoricalFiction;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class HistoricalFictionTest {

    @Test
    @DisplayName("Constructor test from myapp.HistoricalFiction class")
    public void testHistoryFictionTestConstructor() {

        String testName = "myapp.Book Name";
        String testAuthor = "myapp.Book Author";
        String testGenre = "myapp.HistoricalFiction";
        double testPrice = 34.59;
        long testISBN = 939382929;

        HistoricalFiction testBook = new HistoricalFiction(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + " / " + testAuthor, testBook.toString());

    }
}