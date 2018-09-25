package antelopes.kinoxp.models;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReservationTest {

    private Movie movie = new Movie(1, "Avatar", "Horror", 18);
    private Seat seat = new Seat(1, true, "1A");
    private Customer customer = new Customer(1, "Stefan");
    private Reservation reservation = new Reservation(1, movie, LocalDate.parse("2015-03-03"), 1735, seat, customer);

    @Test
    public void getId() {
        assertEquals(1, reservation.getId());
    }

    @Test
    public void setId() {
        reservation.setId(2);
        assertEquals(2, reservation.getId());
    }

    @Test
    public void getCustomer() {
        assertEquals("Stefan", customer.getName());
    }

    @Test
    public void setCustomer() {
        customer.setName("Dragos");
        assertEquals("Dragos", customer.getName());
    }

    @Test
    public void getSeat() {
        assertEquals(true, seat.isAvailable());
    }

    @Test
    public void setSeat() {
        seat.setAvailability(false);
        assertEquals(false, seat.isAvailable());
    }

    @Test
    public void getTime() {
        assertEquals(1735, reservation.getTime());
    }

    @Test
    public void setTime() {
        reservation.setTime(1810);
        assertEquals(1810, reservation.getTime());
    }

    @Test
    public void getDate() {
        assertEquals(LocalDate.parse("2015-03-03"), reservation.getDate());
    }

    @Test
    public void setDate() {
        reservation.setDate(LocalDate.parse("2015-04-04"));
        assertEquals(LocalDate.parse("2015-04-04"), reservation.getDate());

    }

    @Test
    public void getMovieName() {
        assertEquals("Avatar", movie.getName());
    }

}