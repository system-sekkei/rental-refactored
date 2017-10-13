package rental;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    static final Movie newOne = new Movie("新作", Movie.NEW_RELEASE);
    static final Movie children = new Movie("子供向け", Movie.CHILDREN);
    static final Movie regular = new Movie("一般", Movie.REGULAR);
    @Test
    public void smokeTest() {
        Customer customer = new Customer("増田") ;
        customer.addRental(new Rental(newOne,3));
        customer.addRental(new Rental(children,2));
        customer.addRental(new Rental(regular,1));
        System.out.println(customer.statement());
    }

}