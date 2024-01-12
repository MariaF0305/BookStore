package myapp;

import java.util.ArrayList;

public class CrimeThriller extends Book implements Borrowable {
    ArrayList<Book> books = new ArrayList<>();

    public CrimeThriller() {}

    public CrimeThriller(String pName, String pAuthor, String pGenre, double pPrice, long pISBN) {
        super(pName, pAuthor, pGenre, pPrice, pISBN);
    }

    public void addToTheBookListOfThisGenre(Book book) {
        this.books.add(book);
    }

    @Override
    public int bookRequiresCredit() {
        return 7;
    }
}