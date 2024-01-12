package test;

import myapp.ScienceFiction;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ScienceFictionTest {

    @Test
    public  void testBookConstructor () {

        String testName = "myapp.Book Name";
        String testAuthor = "myapp.Book Author";
        String testGenre = "Science Fiction";
        double testPrice = 34.59;
        long testISBN = 939382929;

        ScienceFiction testBook = new ScienceFiction(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + " / " + testAuthor, testBook.toString());

    }

}