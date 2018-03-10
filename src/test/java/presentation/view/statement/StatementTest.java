package presentation.view.statement;

import domain.model.rental.DaysRented;
import domain.model.rental.Rental;
import domain.model.rental.Rentals;
import org.junit.Test;
import domain.model.rental.customer.Customer;
import domain.model.rental.movie.Movie;

import java.time.LocalDate;

public class StatementTest {

    static final Movie newOne = Movie.children("新作", LocalDate.now().minusDays(10));
    static final Movie children = Movie.children("子供", LocalDate.now().minusDays(30*10));
    static final Movie regular = Movie.create("一般", LocalDate.now().minusDays(30*5));
    @Test
    public void smokeTest() {

        Customer customer = new Customer("増田") ;

        Rentals rentals = new Rentals(customer);

        rentals.addRental(new Rental(newOne,new DaysRented(3)));
        rentals.addRental(new Rental(children,new DaysRented(2)));
        rentals.addRental(new Rental(regular,new DaysRented(1)));

        Statement statement = new Statement(rentals);

        System.out.println(statement.statement());
    }

}