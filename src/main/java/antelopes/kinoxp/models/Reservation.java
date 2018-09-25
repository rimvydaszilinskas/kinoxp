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

    public Reservation(int id, Movie movie, String date, double time, Seat seat, Customer customer) {
        this.id = id;
        this.movie = movie;
        this.setDate(date);
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

<<<<<<< HEAD
    public void setDate(String date){
        String[] dateSplit = date.split("-");
        this.date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
    }

    public double getTime() {
=======
    public int getTime() {
>>>>>>> 0ee6ad82897da2eb9844a8e6bda86dbff44d76e6
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
