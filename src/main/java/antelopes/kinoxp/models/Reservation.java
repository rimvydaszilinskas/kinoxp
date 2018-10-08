package antelopes.kinoxp.models;

import java.time.LocalDate;

public class Reservation {

    private String movieName;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int time;
    private String seatNumber;
    private String customerName;
    private int id;


    public Reservation(int id, String movieName, LocalDate date, int time, String seat, String customerName) {
        this.id = id;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.seatNumber = seat;
        this.customerName = customerName;
    }

    public Reservation(int id, String movieName, String date,double time, String seat, String customerName) {
        this.id = id;
        this.movieName = movieName;
        this.setDate(date);
        this.time = (int) time;
        this.seatNumber = seat;
        this.customerName = customerName;
    }

    public Reservation(String movieName, LocalDate date, String seat, String customerName) {
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.seatNumber = seat;
        this.customerName = customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovie(String movieName) {
        this.movieName = movieName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(String date){
        String[] dateSplit = date.split("-");
        this.date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCustomer() {
        return customerName;
    }

    public void setCustomer(String customerName) {
        this.customerName = customerName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
