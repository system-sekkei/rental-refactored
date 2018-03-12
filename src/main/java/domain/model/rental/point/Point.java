package domain.model.rental.point;

import domain.generics.Accumulatable;

public class Point implements Accumulatable<Point> {
    int value;

    Point(int value) {
        this.value = value;
    }

    public static Point zero = new Point(0);
    public static Point one = new Point(1);

    @Override
    public Point add(Point other) {
        return new Point(this.value + other.value);
    }


    @Override
    public String toString() {
        return value + "ポイント";
    }
}
