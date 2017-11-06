package rental;

import org.junit.Test;
import rental.rate.DaysRented;
import rental.rate.NewRelease;
import rental.rate.OldRelease;

import static rental.rate.MovieType.CHILDREN;
import static rental.rate.MovieType.REGULAR;

public class CustomerTest {

    static final Movie newOne = new Movie("新作", new NewRelease());
    static final Movie children = new Movie("子供", new OldRelease(CHILDREN));
    static final Movie regular = new Movie("一般", new OldRelease(REGULAR));
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