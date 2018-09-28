package antelopes.kinoxp.repositories;

import antelopes.kinoxp.models.Seat;

import java.util.List;

public class SeatRepository extends Repository<Seat> {
    public SeatRepository() {
        super();
    }

    @Override
    public Seat get(int id) {
        
        return null;
    }

    @Override
    public List<Seat> getAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Seat object) {
        return false;
    }

    @Override
    public boolean create(Seat object) {
        return false;
    }
}
