package rental;

import static rental.MovieType.NEW_RELEASE;

class Rental {
    Movie movie;
    int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie movie() {
        return movie;
    }

    int amount() {
        Rate movieType = movie.movieType();
        return movieType.amount(daysRented);
    }

    int frequentPoints() {
        Rate movieType = movie.movieType();
        return movieType.point(daysRented);
    }
}
