import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Patryk on 21-03-2017.
 */
public class Reader {
    private String name;
    private String surname;
    private int age;
    private long cashPenalty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCashPenalty() {
        return cashPenalty;
    }

    public void setCashPenalty(Long cashPenalty) {
        this.cashPenalty = cashPenalty;
    }

    public Reader(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cashPenalty = 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", cashPenalty=" + cashPenalty +
                '}';
    }

    public static Reader getReaderFromSet(Set<Reader> readers, int idx)
    {
        int i = 0;
        for (Reader c : readers)
        {
            if (i == idx)
            {
                return c;
            }
            ++i;
        }
        return null;
    }

    public static Set<Reader> generateReaders(int r)
    {
        Random rnd = new Random();
        final String[] names = {"Adam", "Ewa", "Ola", "Ela", "Jan", "Kamil", "Iwan", "Emil", "Patryk", "Alicja", "Mateusz"};
        final String[] surnames = {"Kowal", "Szewczyk", "Muller", "Tracz", "Nowak", "Baran", "Predota", "Janik", "Rydek"};
        Set<Reader> readers = new HashSet<>();
        for (int i = 0; i < r; ++i)
        {
            readers.add(new Reader(names[rnd.nextInt(names.length)], surnames[rnd.nextInt(surnames.length)], 15 + rnd.nextInt(10)));
        }

        return readers;
    }
}

