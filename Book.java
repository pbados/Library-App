import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Patryk on 21-03-2017.
 */
public class Book {
    private String title;
    private String author;
    private int priceOfRenew;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPriceOfRenew() {
        return priceOfRenew;
    }

    public void setPriceOfRenew(int priceOfRenew) {
        this.priceOfRenew = priceOfRenew;
    }

    public Book(String title, String author, int priceOfRenew) {
        this.title = title;
        this.author = author;
        this.priceOfRenew = priceOfRenew;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", priceOfRenew=" + priceOfRenew +
                '}';
    }

    public static Set<Book> generateBooks(int r)
    {
        Random rnd = new Random();
        final String[] titles = {"Romeo i Julia", "Potop", "Zbrodnia i kara", "Lalka", "Pan Tadusz", "Lysek z pokladu Idy", "O psie ktory jezdzil koleja", "Dzieci z Bullerbyn"};
        final String[] autors = {"Czeslaw Milosz", "Fiodor Dostojevsky", "Adam Mickiewicz", "Jan Tuwim"};
        Set<Book> books = new HashSet<>();
        for (int i = 0; i < r; ++i)
        {
            books.add(new Book(titles[rnd.nextInt(titles.length)],autors[rnd.nextInt(autors.length)], 10 + rnd.nextInt(10)));
        }

        return books;
    }
}
