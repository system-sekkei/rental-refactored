package domain.model.rental.customer;

public class Customer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
