import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YoungAdultTest {

    @Test
    public void testYoungAdultConstructor() {

        String testName = "Book Name";
        String testAuthor = "Book Author";
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