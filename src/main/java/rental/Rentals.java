package rental;

import rental.customer.Customer;
import rental.point.Point;

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

    public List<Rental> asList(){
        return rentals;
    }

    public int totalAmount() {
        int result = 0;
        for (Rental each : rentals) {
            result += each.chargeAmount();
        }

        return result;
    }

    public Point totalPoints() {
        Point result = new Point(0);
        for( Rental each : rentals) {
            result = result.add(each.frequentPoints());
        }
       return result;
    }

    public String customerName() {
        return customer.name();
    }
}
