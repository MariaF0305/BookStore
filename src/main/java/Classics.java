import java.util.ArrayList;

public class Classics extends Book implements Borrowable{
    ArrayList<Book> books = new ArrayList<>();

    public Classics () {}

    public Classics(String pName, String pAuthor, String pGenre, double pPrice, long pISBN) {
        super(pName, pAuthor, pGenre, pPrice, pISBN);
    }

    public void addToTheBookListOfThisGenre(Book book) {
        this.books.add(book);
    }

    @Override
    public int bookRequiresCredit() {
        return 4;
    }

    @Override
    public String toString() {
        return "Genre: Classics " + super.toString();
    }
}
