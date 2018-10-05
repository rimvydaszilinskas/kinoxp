package antelopes.kinoxp.models;

import java.util.LinkedList;
import java.util.List;

public class Movie {

    private String name, genre;
    private int ageLimit, id;
    private List<Seat> seats;

    public Movie(int id, String name, String genre, int ageLimit) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.seats = new LinkedList<>();
    }

    public Movie(String name, String genre, int ageLimit, List<Seat> seats) {
        this.name = name;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

