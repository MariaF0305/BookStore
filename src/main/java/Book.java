import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Classics.class, name = "Classics"),
        @JsonSubTypes.Type(value = CrimeThriller.class, name = "ChrimeThriller"),
        @JsonSubTypes.Type(value = Fantasy.class, name = "Fantasy"),
        @JsonSubTypes.Type(value = HistoricalFiction.class, name = "HistoricalFiction"),
        @JsonSubTypes.Type(value = LiteraryFiction.class, name = "LiteraryFiction"),
        @JsonSubTypes.Type(value = Romance.class, name = "Romance"),
        @JsonSubTypes.Type(value = ScienceFiction.class, name = "ScienceFiction"),
        @JsonSubTypes.Type(value = YoungAdult.class, name = "YoungAdult") }
)

public abstract class Book implements  Serializable {
    public Book(){};
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

    public String getName() { return this.mName; }

    public void setName(String mName) { this.mName = mName; }

    public String getAuthor() { return this.mAuthor; }
    public void setAuthor(String mAuthor) { this.mAuthor = mAuthor; }

    public String getGenre() { return this.mGenre; }
    public void setGenre(String mGenre) { this.mGenre = mGenre; }

    public double getPrice() { return this.mPrice; }
    public void setPrice(float mPrice) { this.mPrice = mPrice; }

    public long getISBN () {return this.mISBN; }
    public void setISBN(long mISBN) { this.mISBN = mISBN; }

    @Override
    public String toString() {
        return this.mName + " / "+ this.mAuthor;
    }
}