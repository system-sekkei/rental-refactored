package domain.model.rental.movie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Movie {

    String title;

    LocalDate releaseDate;
    MovieType type = MovieType.General;


    Movie(String title, LocalDate releaseDate, MovieType type) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public static Movie children(String title, LocalDate releaseDate) {
        return new Movie(title,releaseDate,MovieType.Children);
    }

    public static Movie create(String title, LocalDate releaseDate) {
        return new Movie(title,releaseDate,MovieType.General);
    }

    public long daysFromRelease() {
        return ChronoUnit.DAYS.between(releaseDate, LocalDate.now());
    }

    public boolean forChildren() {
        return type == MovieType.Children;
    }

    @Override
    public String toString() {
        return title;
    }
}
