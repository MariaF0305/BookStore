import java.util.ArrayList;

public class ScienceFiction extends Book implements Borrowable{
    ArrayList<Book> books = new ArrayList<>();

    public ScienceFiction() {}

    public ScienceFiction(String pName, String pAuthor, String pGenre, double pPrice, long pISBN) {
        super(pName, pAuthor, pGenre, pPrice, pISBN);
    }

    public void addToTheBookListOfThisGenre(Book book) {
        this.books.add(book);
    }

    @Override
    public int bookRequiresCredit() {
        return 8;
    }

}
