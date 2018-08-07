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
        int totalAmount = 0;
        int frequentRentalPoints = 0;

        String result = "レンタル記録 " + name() + "\n";

        for (Rental each : rentals) {
            int thisAmount = each.amount();

            frequentRentalPoints ++;
            if( each.movie().priceCode() == Movie.NEW_RELEASE && each.daysRented() > 1 )
                frequentRentalPoints ++;

            result += "\t" + each.movie().title() + "\t" + thisAmount + "\n";

            totalAmount += thisAmount;

        }

        result += "レンタル金額 " + totalAmount + "円\n";
        result += "獲得ポイント " + frequentRentalPoints + "p";
        return result;
    }
}
