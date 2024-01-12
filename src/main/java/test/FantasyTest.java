package test;

import myapp.Fantasy;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class FantasyTest {

    @Test
    @DisplayName("Constructor test from myapp.Fantasy class")
    public void testFantasyTestConstructor() {

        String testName = "myapp.Book Name";
        String testAuthor = "myapp.Book Author";
        String testGenre = "myapp.Fantasy";
        double testPrice = 34.59;
        long testISBN = 939382929;

        Fantasy testBook = new Fantasy(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + " / " + testAuthor, testBook.toString());

    }
}