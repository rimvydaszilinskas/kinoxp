package antelopes.kinoxp.models;

public class Seat {

    private int id;
    private boolean availability;
    private String name; // 1A, 1B

    public Seat(int id, boolean availability, String name) {
        this.id = id;
        this.availability = availability;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

