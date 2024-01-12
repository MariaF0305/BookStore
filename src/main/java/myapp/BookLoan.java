package myapp;

import java.io.Serializable;
import java.util.ArrayList;

public class BookLoan implements Serializable {
    private ArrayList<Book> mListOfBooks = new ArrayList<>();
    private User mUser;

    public BookLoan() {};
    public BookLoan(User pUser) {
        this.mUser = pUser;
    }

    public void addBookToUsersList (Book pBook) {
        this.mListOfBooks.add(pBook);
    }
    public ArrayList<Book> remove(Book pBook) {
        for (Book b : this.mListOfBooks) {
            if (b == pBook) {
                this.mListOfBooks.remove(pBook);
            }
        }
        return this.mListOfBooks;
    }

    public User getUser() {
        return this.mUser;
    }
    public void setUser(User mUser) { this.mUser = mUser; }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("User: " + mUser + "\n");
        int i=0;
        for (Book b:this.mListOfBooks){
            i++;
            sb.append("\t book: " + i + ":" + b + "\n");
        }
        return sb.toString();
    }

    public ArrayList<Book> getListOfBooks() {
        return this.mListOfBooks;
    }

}
