package antelopes.kinoxp.models;

public class Movie {

    private String movieName, genre;
    private int ageLimit, id;

    public Movie(int id, String name, String genre, int ageLimit) {
        this.id = id;
        this.movieName = name;
        this.genre = genre;
        this.ageLimit = ageLimit;
    }

    public String getName() {
        return movieName;
    }

    public void setName(String name) {
        this.movieName = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

