package presentation.view.statement;

import domain.model.rental.Rental;
import domain.model.rental.Rentals;

public class Statement {

    Rentals rentals;
    public Statement(Rentals rentals) {
        this.rentals = rentals;
    }

    public String statement() {


        String result = "レンタル記録 " + rentals.customer() + "\n\n";

        for (Rental each : rentals.asList()) {
            result += each.movie() + "\t" + each.chargeAmount() + "\n";
        }

        result += "\n";
        result += "レンタル金額 " + rentals.totalAmount() + "\n";
        result += "獲得ポイント " +  rentals.totalPoints() + "\n";
        return result;
    }
}
