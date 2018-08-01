package domain.model.rental;

import domain.generics.Total;
import domain.model.rental.charge.Charge;
import domain.model.rental.customer.Customer;
import domain.model.rental.point.Point;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    Customer customer;
    List<Rental> rentals = new ArrayList<>();

    public Rentals(Customer customer) {
        this.customer = customer;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> asList(){
        return rentals;
    }

    public Charge charge() {
        Total<Rental, Charge> total = new Total<>(rentals,Rental::amount);
        return total.sum();
    }

    public Point points() {
        Total<Rental, Point> total = new Total<>( rentals, Rental::points);
       return total.sum();
    }

    public Customer customer() {
        return customer;
    }
}
