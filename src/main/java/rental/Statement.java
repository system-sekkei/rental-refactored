package rental;

import static rental.MovieType.*;

class Statement {

    Rentals rentals;
    Statement(Rentals rentals) {
        this.rentals = rentals;
    }

    String statement() {


        String result = "レンタル記録 " + rentals.customerName() + "\n";

        for (Rental each : rentals.asList()) {
            result += "\t" + each.movie().title() + "\t" + each.amount() + "\n";
        }

        int totalAmount = rentals.totalAmount();
        int frequentRenterPoints = rentals.totalPoints();

        result += "レンタル金額 " + totalAmount + "円\n";
        result += "獲得ポイント " + frequentRenterPoints + "p";
        return result;
    }
}
