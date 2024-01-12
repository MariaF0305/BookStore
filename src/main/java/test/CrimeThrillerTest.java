package test;

import myapp.CrimeThriller;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class CrimeThrillerTest {

    @Test
    @DisplayName("Constructor test from myapp.CrimeThriller class")
    public void testCrimeThrillerTestConstructor() {

        String testName = "myapp.Book Name";
        String testAuthor = "myapp.Book Author";
        String testGenre = "myapp.CrimeThriller";
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