package presentation.view.statement;

import domain.model.rental.Days;
import domain.model.rental.Rental;
import domain.model.rental.Rentals;
import domain.model.rental.movie.ReleaseDate;
import org.junit.Test;
import domain.model.rental.customer.Customer;
import domain.model.rental.movie.Movie;

import java.time.LocalDate;

public class StatementTest {

    static final ReleaseDate tenDaysBefore =  new ReleaseDate(LocalDate.now().minusDays(10));
    static final ReleaseDate tenMonthsBefore =  new ReleaseDate(LocalDate.now().minusMonths(10));
    static final ReleaseDate fiveMonthsBefore =  new ReleaseDate(LocalDate.now().minusMonths(5));


    static final Movie newOne = Movie.children("新作", tenDaysBefore);
    static final Movie children = Movie.children("子供", tenMonthsBefore);
    static final Movie regular = Movie.create("一般", fiveMonthsBefore);
    @Test
    public void smokeTest() {

        Customer customer = new Customer("田中　明") ;

        Rentals rentals = new Rentals(customer);

        rentals.addRental(new Rental(newOne,Days.of(3)));
        rentals.addRental(new Rental(children,Days.of(2)));
        rentals.addRental(new Rental(regular,Days.of(1)));

        Statement statement = new Statement(rentals);

        System.out.println(statement.statement());
    }

}