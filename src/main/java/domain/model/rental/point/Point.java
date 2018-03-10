package domain.model.rental.point;

import domain.generics.Accumulatable;

public class Point implements Accumulatable<Point> {
    int value;

    public Point(int value) {
        this.value = value;
    }

    @Override
    public Point add(Point other) {
        return new Point(this.value + other.value);
    }


    @Override
    public String toString() {
        return value + "p";
    }
}
