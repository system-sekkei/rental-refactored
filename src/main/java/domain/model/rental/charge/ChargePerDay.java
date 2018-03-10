package domain.model.rental.charge;

import domain.model.rental.DaysRented;

/**
 * 一日あたりの料金
 */

class ChargePerDay {

    Charge perDay;

    ChargePerDay(int perDay) {
        this.perDay = new Charge(perDay);
    }

    public Charge forDays(DaysRented daysRented) {
        return new Charge(perDay.value * daysRented.intValue());
    }
}
