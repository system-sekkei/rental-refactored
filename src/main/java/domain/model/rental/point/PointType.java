package domain.model.rental.point;

import domain.model.rental.Days;
import domain.model.rental.movie.Movie;

public enum PointType {

    NEW_RELEASE(Point.one),
    OLD_RELEASE(Point.zero);

    Point basePoint = Point.one;

    Point bonusPoint;
    static Days bonusCriteria = Days.of(1);

    PointType(Point bonusPoint) {
        this.bonusPoint = bonusPoint;
    }


    public Point point(Days daysRented)  {
        if(daysRented.within(bonusCriteria)) return basePoint;
        return basePoint.add(bonusPoint);
    }

    public static PointType of(Movie movie) {
        if(movie.isNewRelease()) return NEW_RELEASE;
        return OLD_RELEASE;
    }
}
