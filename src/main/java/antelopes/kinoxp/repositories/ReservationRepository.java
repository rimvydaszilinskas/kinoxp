package antelopes.kinoxp.repositories;

import antelopes.kinoxp.models.Movie;
import antelopes.kinoxp.models.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationRepository extends Repository<Reservation> {
    public ReservationRepository() {
        super();
    }

    @Override
    public Reservation get(int id) {
        try{
            preparedStatement = connection.prepareStatement("SELECT reservations.id, reservations.seat_number, reservations_date, reservations_time, " +
                    "movies.id, movies.name, movies.genre, movies.age_limit, customers.id, " +
                    "customers.name FROM reservations " +
                    "INNER JOIN movies ON reservation.movie_id=movies.id " +
                    "INNER JOIN customers ON reservation.customer_id=customers.id WHERE reservations.id=?");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                Movie movie = new Movie(resultSet.getInt(""))
                return new Reservation(
                        resultSet.getInt("id"),
                        resultSet.get
                );
            }
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Reservation object) {
        return false;
    }

    @Override
    public boolean create(Reservation object) {
        return false;
    }
}
