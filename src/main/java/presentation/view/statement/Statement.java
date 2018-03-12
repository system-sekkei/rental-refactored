package presentation.view.statement;

import domain.model.rental.Rental;
import domain.model.rental.Rentals;

public class Statement {

    Rentals rentals;

    Statement(Rentals rentals) {
        this.rentals = rentals;
    }

    public String statement() {
        return String.format(
                "%s\n%s\n%s", header(), details(), footer());
    }

    String header() {
        return String.format("レンタル記録 %s\n", rentals.customer());
    }

    String details() {
        StringBuilder result = new StringBuilder();
        for (Rental each : rentals.asList()) {
            result.append(String.format("%s\t%s\n" , each.movie() ,each.chargeAmount()));
        }
        return result.toString();
    }

    String footer() {
        return String.format("%s\n%s\n", totalCharge(), totalPoints());
    }

    String totalCharge() {
        return String.format("レンタル金額 %s", rentals.totalAmount());
    }

    String totalPoints() {
        return String.format("獲得ポイント %s" , rentals.totalPoints());
    }
}
