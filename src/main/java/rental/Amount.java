package rental;

public class Amount {
    int value;

    Amount(int value) {
        this.value = value;
    }

    Amount add(Amount other) {
        return new Amount(this.value + other.value);
    }
}
