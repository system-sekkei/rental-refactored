package rental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    Customer customer;
    List<Rental> rentals = new ArrayList<>();

    Rentals(Customer customer) {
        this.customer = customer;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    List<Rental> asList(){
        return rentals;
    }

    int totalAmount() {
        int result = 0;
        for (Rental each : rentals) {
            result += each.amount();
        }

        return result;
    }

    int totalPoints() {
        int result = 0;
        for( Rental each : rentals) {
            result += each.frequentPoints();
        }
       return result;
    }

    String customerName() {
        return customer.name();
    }
}
