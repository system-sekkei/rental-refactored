package rental;

import static rental.MovieType.*;

class Statement {

    Customer customer;
    Statement(Customer customer) {
        this.customer = customer;
    }

    String statement() {
        int totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "レンタル記録 " + customer.name() + "\n";

        for (Rental each : customer.rentals.asList()) {
            int thisAmount = each.amount();

            frequentRenterPoints ++;
            if( each.movie().movieType() == NEW_RELEASE && each.daysRented() > 1 )
                frequentRenterPoints ++;

            result += "\t" + each.movie().title() + "\t" + thisAmount + "\n";

            totalAmount += thisAmount;
        }

        result += "レンタル金額 " + totalAmount + "円\n";
        result += "獲得ポイント " + frequentRenterPoints + "p";
        return result;
    }
}
