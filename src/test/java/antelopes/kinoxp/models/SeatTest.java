package antelopes.kinoxp.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeatTest {

    private Seat seat = new Seat(1, true, "1A");

    @Test
    public void getAvailability() {
        assertEquals(true, seat.isAvailable());
    }

    @Test
    public void setAvailability() {
        seat.setBooked(false);
        assertEquals(false, seat.isAvailable());
    }

    @Test
    public void getName() {
        assertEquals("1A", seat.getSpace());
    }

    @Test
    public void setName() {
        seat.setSpace("2A");
        assertEquals("2A", seat.getSpace());
    }

    @Test
    public void getId() {
        assertEquals(1, seat.getId());
    }

    @Test
    public void setId() {
        seat.setId(2);
        assertEquals(2, seat.getId());
    }
}