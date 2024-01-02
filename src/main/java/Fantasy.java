import java.util.ArrayList;

public class Fantasy extends Book implements Borrowable{
    ArrayList<Book> books = new ArrayList<>();

    public Fantasy() {}

    public Fantasy(String pName, String pAuthor, String pGenre, double pPrice, long pISBN) {
        super(pName, pAuthor, pGenre, pPrice, pISBN);
    }

    public void addToTheBookListOfThisGenre(Book book) {
        this.books.add(book);
    }

    @Override
    public int bookRequiresCredit() {
        return 6;
    }

}
