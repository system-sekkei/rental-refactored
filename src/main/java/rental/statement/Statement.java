package rental.statement;

import rental.Rental;
import rental.Rentals;

public class Statement {

    Rentals rentals;
    public Statement(Rentals rentals) {
        this.rentals = rentals;
    }

    public String statement() {


        String result = "レンタル記録 " + rentals.customerName() + "\n";

        for (Rental each : rentals.asList()) {
            result += "\t" + each.movie().title() + "\t" + each.chargeAmount() + "\n";
        }

        int totalAmount = rentals.totalAmount();

        result += "レンタル金額 " + totalAmount + "円\n";
        result += "獲得ポイント " +  rentals.totalPoints();
        return result;
    }
}
