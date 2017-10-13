package rental;

import java.util.ArrayList;
import java.util.List;

class Customer {
    String name;
    List<Rental> rentals = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String name() {
        return name;
    }

    String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + name() + "\n";

        for (Rental each : rentals) {
            double thisAmount = 0;
            switch( each.movie().priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if( each.daysRented()>2) thisAmount += (each.daysRented -2 ) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.daysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if(each.daysRented() > 3) thisAmount += (each.daysRented() -3 ) * 1.5;
                    break;
            }

            frequentRenterPoints ++;
            if( each.movie().priceCode() == Movie.NEW_RELEASE && each.daysRented() > 1 )
                frequentRenterPoints ++;

            result += "\t" + each.movie().title() + "\t" + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;

        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
