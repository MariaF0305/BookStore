import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class BookTest {

    public  void testBookConstructor () {

        String testName = "Book Name";
        String testAuthor = "Book Author";
        String testGenre = "Science Fiction";
        double testPrice = 34.59;
        long testISBN = 939382929;

        ScienceFiction testBook = new ScienceFiction(testName, testAuthor, testGenre, testPrice, testISBN);

        assertEquals(testName, testBook.getName());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(testGenre, testBook.getGenre());
        assertEquals(testPrice, testBook.getPrice());
        assertEquals(testISBN, testBook.getISBN());

        assertEquals(testName + testAuthor, testBook.toString());

    }

}