package antelopes.kinoxp.models;

import java.time.LocalDate;

public class Reservation {

    private Movie movie;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int time;
    private Seat seat;
    private Customer customer;
    private int id;


    public Reservation(int id, Movie movie, LocalDate date, int time, Seat seat, Customer customer) {
        this.id = id;
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.seat = seat;
        this.customer = customer;
    }

    public String getMovieName() {
        return movie.getName();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
