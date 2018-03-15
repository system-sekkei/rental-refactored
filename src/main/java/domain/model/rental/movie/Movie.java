package domain.model.rental.movie;

public class Movie {

    String title;

    ReleaseDate releaseDate;
    Category type;


    Movie(String title, ReleaseDate releaseDate, Category type) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public static Movie children(String title, ReleaseDate releaseDate) {
        return new Movie(title,releaseDate, Category.Children);
    }

    public static Movie create(String title, ReleaseDate releaseDate) {
        return new Movie(title,releaseDate, Category.General);
    }

    public boolean forChildren() {
        return type == Category.Children;
    }

    public boolean isNewRelease() {
        return releaseDate.isNewRelease();
    }

    @Override
    public String toString() {
        return title;
    }
}
