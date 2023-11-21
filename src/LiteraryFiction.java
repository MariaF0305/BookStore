import java.util.ArrayList;

public class LiteraryFiction extends Book implements Borrowable{
    ArrayList<Book> books = new ArrayList<>();

    public LiteraryFiction(String pName, String pAuthor, String pGenre, double pPrice, long pISBN) {
        super(pName, pAuthor, pGenre, pPrice, pISBN);
    }

    public void addToTheBookListOfThisGenre(Book book) {
        this.books.add(book);
    }

    @Override
    public int bookRequiresCredit() {
        return 3;
    }

}
