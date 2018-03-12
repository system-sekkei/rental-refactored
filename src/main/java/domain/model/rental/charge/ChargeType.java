package domain.model.rental.charge;

import domain.model.rental.Days;

public enum ChargeType {
    NEW_RELEASE(Charge.of(0), Days.of(0), PerDay.of(300)),
    REGULAR(Charge.of(200),Days.of(2),PerDay.of(150)),
    CHILDREN(Charge.of(150),Days.of(3),PerDay.of(150));

    Charge baseCharge;
    Days baseDays;
    PerDay perDay;

    ChargeType(Charge baseCharge, Days baseDays, PerDay perDay) {
        this.baseCharge = baseCharge;
        this.baseDays = baseDays;
        this.perDay = perDay;
    }

    public Charge amount(Days days) {
        if( days.within(baseDays) ) return baseCharge;

        Days additionalDays = days.minus(baseDays);
        Charge additional = perDay.forDays(additionalDays);
        return baseCharge.add(additional);
    }
}
