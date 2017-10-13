package rental;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void smokeTest() {
        Customer customer = new Customer("増田") ;
        customer.addRental(new Rental(new Movie("title", Movie.NEW_RELEASE), 3));
        System.out.println(customer.statement());
    }

}