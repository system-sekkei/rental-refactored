package rental;

import static rental.MovieType.*;

class Statement {

    Customer customer;
    Statement(Customer customer) {
        this.customer = customer;
    }

    String statement() {

        int frequentRenterPoints = 0;
        String result = "レンタル記録 " + customer.name() + "\n";

        for (Rental each : customer.rentals.asList()) {
            frequentRenterPoints += each.frequentPoints();
            result += "\t" + each.movie().title() + "\t" + each.amount() + "\n";
        }

        int totalAmount = customer.rentals.totalAmount();

        result += "レンタル金額 " + totalAmount + "円\n";
        result += "獲得ポイント " + frequentRenterPoints + "p";
        return result;
    }
}
