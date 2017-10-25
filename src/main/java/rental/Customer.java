package rental;

import java.util.ArrayList;
import java.util.List;

class Customer {
    String name;
    Rentals rentals = new Rentals();

    Customer(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    String name() {
        return name;
    }

    String statement() {
        int totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "レンタル記録 " + name() + "\n";

        for (Rental each : rentals.asList()) {
            int thisAmount = 0;
            switch( each.movie().priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 200;
                    if( each.daysRented()>2) thisAmount += (each.daysRented -2 ) * 150;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.daysRented() * 300;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 150;
                    if(each.daysRented() > 3) thisAmount += (each.daysRented() -3 ) * 150;
                    break;
            }

            frequentRenterPoints ++;
            if( each.movie().priceCode() == Movie.NEW_RELEASE && each.daysRented() > 1 )
                frequentRenterPoints ++;

            result += "\t" + each.movie().title() + "\t" + thisAmount + "\n";

            totalAmount += thisAmount;

        }

        result += "レンタル金額 " + totalAmount + "円\n";
        result += "獲得ポイント " + frequentRenterPoints + "p";
        return result;
    }
}
