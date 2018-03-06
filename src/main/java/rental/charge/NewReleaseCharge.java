package rental.charge;

import rental.rate.DaysRented;
import rental.rate.Rate;

public class NewReleaseCharge implements Charge {

    int amountPerDay = 300;

    @Override
    public int amountFor(DaysRented daysRented) {
        return amountPerDay * daysRented.intValue();
    }
  }
