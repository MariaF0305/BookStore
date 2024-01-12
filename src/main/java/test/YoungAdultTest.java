package test;

import myapp.YoungAdult;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class YoungAdultTest {

    @Test
    public void testYoungAdultConstructor() {

        String testName = "myapp.Book Name";
        String testAuthor = "myapp.Book Author";
        String testGenre = "Young Adult";
        double testPrice = 34.59;
        long testISBN = 939382929;

        YoungAdult testBook = new YoungAdult(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + " / " + testAuthor, testBook.toString());

    }

}