import java.io.Serializable;

public abstract class Book implements  Serializable { // class C
    private String mName;
    private String mAuthor;
    private String mGenre;
    private double mPrice;
    private long mISBN;

    public Book (String pName, String pAuthor, String pGenre, double pPrice, long pISBN) {
        this.mName = pName;
        this.mAuthor = pAuthor;
        this.mGenre = pGenre;
        this.mPrice = pPrice;
        this.mISBN = pISBN;
    }

    public String getName() {
        return this.mName;
    }

    public String getAuthor() {
        return this.mAuthor;
    }

    public String getGenre() {
        return this.mGenre;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public long getISBN () {return this.mISBN; }

    @Override
    public String toString() {
        return this.mName + " / "+ this.mAuthor;
    }
}