import java.util.ArrayList;

public class YoungAdult extends Book implements Borrowable{
    ArrayList<Book> books = new ArrayList<>();

    public YoungAdult(String pName, String pAuthor, String pGenre, double pPrice, long pISBN) {
        super(pName, pAuthor, pGenre, pPrice, pISBN);
    }

    public ArrayList<Book> addToTheBookListOfThisGenre(Book book) {
        this.books.add(book);

        return this.books;
    }

    @Override
    public int bookRequiresCredit() {
        return 6;
    }

}
