package test;

import myapp.Classics;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


public class ClassicsTest {

    @Test
    @DisplayName("Constructor test from myapp.Classics class")
    public void testClassicsTestConstructor() {

        String testName = "myapp.Book Name";
        String testAuthor = "myapp.Book Author";
        String testGenre = "myapp.Classics";
        double testPrice = 34.59;
        long testISBN = 939382929;

        Classics testBook = new Classics(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + " / " + testAuthor, testBook.toString());

    }
}