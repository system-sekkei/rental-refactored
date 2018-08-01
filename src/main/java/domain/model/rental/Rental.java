package domain.model.rental;


import domain.model.rental.charge.Charge;
import domain.model.rental.charge.ChargeType;
import domain.model.rental.movie.Movie;
import domain.model.rental.point.Point;
import domain.model.rental.point.PointType;

public class Rental {
    Movie movie;
    Days days;

    public Rental(Movie movie, Days days) {
        this.movie = movie;
        this.days = days;
    }

    public Movie movie() {
        return movie;
    }

    public Days days() {
        return days;
    }

    public Charge chargeAmount() {
        ChargeType type = ChargeType.of(movie);
        return type.amount(days);
    }

    public Point frequentPoints() {
        PointType type = PointType.of(movie);
        return type.point(days);
    }
}
