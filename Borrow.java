import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Patryk on 21-03-2017.
 */
public class Borrow {
    private Book book;
    private Reader reader;
    private LocalDate dateOfBorrow;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDate getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(LocalDate dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public Borrow(Book book, Reader reader, LocalDate dateOfBorrow) {
        this.book = book;
        this.reader = reader;
        this.dateOfBorrow = dateOfBorrow;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "book=" + book +
                ", reader=" + reader +
                ", dateOfBorrow=" + dateOfBorrow +
                '}';
    }

    public static Set<Borrow> generateWypozyczenia(Set<Book> ksiazki, Set<Reader> czytelnicy)
    {
        Random rnd = new Random();
        int idx, day, month, year;

        Set<Borrow> wypozyczenia = new HashSet<>();

        for (Book k : ksiazki)
        {
            idx = rnd.nextInt(czytelnicy.size());
            day = 1 + rnd.nextInt(30);
            month = 1 + rnd.nextInt(12);
            year = 2016 + rnd.nextInt(1);
            wypozyczenia.add(new Borrow(k, Reader.getReaderFromSet(czytelnicy, idx), LocalDate.of(year,month,day)));
        }
        return wypozyczenia;
    }
}
