package domain.model.rental.charge;

import domain.model.rental.Days;

/**
 * 一日あたりの料金
 */

class PerDay {

    Charge perDay;

    PerDay(int perDay) {
        this.perDay = Charge.of(perDay);
    }

    Charge forDays(Days days) {
        return Charge.of(perDay.value * days.intValue());
    }

    static PerDay of(int value) {
        return new PerDay(value);
    }

}
