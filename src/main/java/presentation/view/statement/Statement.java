package presentation.view.statement;

import domain.model.rental.Rental;
import domain.model.rental.Rentals;

import java.time.LocalDate;

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
        return String.format(
                "レンタル記録 %s様 %s\n",
                rentals.customer(), LocalDate.now());
    }

    String details() {
        StringBuilder result = new StringBuilder();
        for (Rental each : rentals.asList()) {
            addDetail(result, each);
        }
        return result.toString();
    }

    private void addDetail(StringBuilder result, Rental each) {
        result.append(String.format(
                "%s\t%s\t%s\t%s\n" ,
                each.movie(), each.days(), each.amount(), each.points()));
    }

    String footer() {
        return String.format("%s\n%s\n", totalCharge(), totalPoints());
    }

    String totalCharge() {
        return String.format("レンタル金額 %s", rentals.charge());
    }

    String totalPoints() {
        return String.format("獲得ポイント %s" , rentals.points());
    }
}
