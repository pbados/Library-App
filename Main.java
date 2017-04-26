import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Created by Patryk on 21-03-2017.
 */
public class Main {

    public static void readersPenalties(Set<Borrow> bor, List<Reader> penalties){

        LocalDate today = LocalDate.now();

        for(Borrow w : bor){
            if(w.getDateOfBorrow().until(today, ChronoUnit.DAYS) > 14){
                for(Reader c: penalties){
                    if(w.getReader().getName().equals(c.getName()) && w.getReader().getSurname().equals(c.getSurname())){
                        //if Reader is younger than 18 yo
                        if(c.getAge()<=18){
                            Long penalty = 5*w.getDateOfBorrow().until(today, ChronoUnit.DAYS);
                            c.setCashPenalty(penalty/2);
                        }else {
                            Long penalty = 5 * w.getDateOfBorrow().until(today, ChronoUnit.DAYS);
                            c.setCashPenalty(penalty);
                        }
                    }
                }

            }
        }
    }


    public static void main(String[] args) {

        Set<Reader> readers = Reader.generateReaders(10);
        Set<Book> books = Book.generateBooks(15);
        Set<Borrow> borrows = Borrow.generateWypozyczenia(books, readers);

        System.out.println("=========LIST OF BORROWED BOOKS BY READERS==========");

        borrows.forEach(w -> {
            System.out.println(w);
        });

        List<Reader> penalties = new ArrayList<>();


        for (Reader c : readers)
        {
            if (!penalties.contains(c))
            {
                penalties.add(c);
            }
        }

        readersPenalties(borrows, penalties);
        System.out.println("=========PENALTIES TO BE PAID BY READERS SORTED BY SIZE=========");

        penalties
                .stream()
                .sorted((c1,c2) ->  Long.compare(c2.getCashPenalty(), c1.getCashPenalty()))
                .forEach(k -> System.out.println(k));


    }
}