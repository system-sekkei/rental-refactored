package rental;

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

    int daysRented() {
        return daysRented;
    }

    int amount() {
        int baseAmount = 0;
        int additionalAmount = 0;
        switch( movie.priceCode()) {
            case Movie.REGULAR:
                baseAmount = 200;
                if(daysRented()>2) additionalAmount = (daysRented -2 ) * 150;
                break;
            case Movie.NEW_RELEASE:
                baseAmount = daysRented() * 300;
                break;
            case Movie.CHILDREN:
                baseAmount = 150;
                if(daysRented() > 3) additionalAmount = (daysRented() -3 ) * 150;
                break;
        }
        return baseAmount + additionalAmount;
    }

}
