package rental;

import org.junit.Test;
import rental.customer.Customer;
import rental.movie.Movie;
import rental.movie.MovieType;

import rental.statement.Statement;

import java.time.LocalDate;

public class CustomerTest {

    static final Movie newOne = new Movie("新作", LocalDate.now().minusDays(10), MovieType.Children);
    static final Movie children = new Movie("子供", LocalDate.now().minusDays(30*10),MovieType.Children);
    static final Movie regular = new Movie("一般", LocalDate.now().minusDays(30*5), MovieType.General);
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