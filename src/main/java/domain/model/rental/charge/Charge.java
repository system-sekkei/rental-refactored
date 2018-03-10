package domain.model.rental.charge;

import domain.generics.Accumulatable;

public class Charge implements Accumulatable<Charge> {
    int value ;

    public Charge(int value) {
        this.value = value;
    }

    @Override
    public Charge add(Charge other) {
        return new Charge(this.value + other.value);
    }

    @Override
    public String toString() {
        return value + "円";
    }
}
