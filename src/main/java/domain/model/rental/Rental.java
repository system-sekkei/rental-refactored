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

    public Charge chargeAmount() {
        return chargeType().amount(days);
    }

    private ChargeType chargeType() {
        if(isNewRelease()) return ChargeType.NEW_RELEASE;
        if(movie.forChildren()) return ChargeType.CHILDREN;
        return ChargeType.REGULAR;
    }
    private boolean isNewRelease() {
        return movie.daysFromRelease() < 90;
    }

    Point frequentPoints() {
        return pointType().point(days);
    }

    private PointType pointType() {
        if(isNewRelease()) return PointType.NEW_RELEASE;
        return PointType.OLD_RELEASE;
    }
}
