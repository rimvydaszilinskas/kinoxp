package antelopes.kinoxp.repositories;

import antelopes.kinoxp.models.Customer;
import antelopes.kinoxp.models.Movie;
import antelopes.kinoxp.models.Reservation;
import antelopes.kinoxp.models.Seat;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReservationRepository extends Repository<Reservation> {
    private SeatRepository seatRepository = new SeatRepository();
    public ReservationRepository() {
        super();
    }

    @Override
    public Reservation get(int id) {
        try{
            preparedStatement = connection.prepareStatement("SELECT reservations.id, reservations.seat_number, reservations_date, reservations_time, " +
                    "movies.id, movies.name, movies.genre, movies.ageLimit, customers.id, " +
                    "customers.name, seats.id, seats.space FROM reservations " +
                    "INNER JOIN movies ON reservations.movie_id=movies.id " +
                    "INNER JOIN customers ON reservations.customer_id=customers.id " +
                    "INNER JOIN seats ON reservations.seat_id=seats.id WHERE reservations.id=?");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                Movie movie = new Movie(
                        resultSet.getInt("movies.id"),
                        resultSet.getString("movies.name"),
                        resultSet.getString("movies.genre"),
                        resultSet.getInt("movies.ageLimit"));
                Customer customer = new Customer(
                        resultSet.getInt("customers.id"),
                        resultSet.getString("customers.name")
                );
                return new Reservation(
                        resultSet.getInt("reservations.id"),
                        movie,
                        resultSet.getString("reservations.date"),
                        resultSet.getInt("reservations.time"),
                        resultSet.getString("seats.space"),
                        customer
                );
            }
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        List<Reservation> reservations = new LinkedList<>();
        try{
            preparedStatement = connection.prepareStatement("SELECT reservations.id, reservations.seat_number, reservations_date, reservations_time, " +
                    "movies.id, movies.name, movies.genre, movies.ageLimit, customers.id, " +
                    "customers.name, seats.id, seats.space FROM reservations " +
                    "INNER JOIN movies ON reservations.movie_id=movies.id " +
                    "INNER JOIN customers ON reservations.customer_id=customers.id " +
                    "INNER JOIN seats ON reservations.seat_id=seats.id");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Movie movie = new Movie(
                        resultSet.getInt("movies.id"),
                        resultSet.getString("movies.name"),
                        resultSet.getString("movies.genre"),
                        resultSet.getInt("movies.ageLimit"));
                Customer customer = new Customer(
                        resultSet.getInt("customers.id"),
                        resultSet.getString("customers.name")
                );
                reservations.add(new Reservation(
                        resultSet.getInt("reservations.id"),
                        movie,
                        resultSet.getString("reservations.date"),
                        resultSet.getInt("reservations.time"),
                        resultSet.getString("seats.space"),
                        customer));
            }
        } catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return reservations;
    }

    @Override
    public boolean delete(int id) {
        try{
            Reservation reservation = this.get(id);
            preparedStatement = connection.prepareStatement("UPDATE seats SET booked=0 WHERE space=?");
            preparedStatement.setString(1, reservation.getSeatNumber());

            if(preparedStatement.execute()){
                preparedStatement = connection.prepareStatement("DELETE FROM reservations WHERE id=?");
                preparedStatement.setInt(1, id);

                if(preparedStatement.execute())
                    return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return false;
    }

    @Override
    public boolean update(Reservation object) {
        try{
            int oldSeatID = 0;
            preparedStatement = connection.prepareStatement("SELECT seat_id FROM reservation WHERE id=?");
            preparedStatement.setInt(1, object.getId());

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                oldSeatID = resultSet.getInt("seat_id");
            }
            preparedStatement = connection.prepareStatement("UPDATE reservations SET movie_id=?, seat_number=?, date=?, time=? WHERE id=?");
            preparedStatement.setInt(1, object.getMovie().getId());
            preparedStatement.setString(2, object.getSeatNumber());
            preparedStatement.setString(3, object.getDate().toString());
            preparedStatement.setInt(4, object.getTime());
            preparedStatement.setInt(5, object.getId());

            if(preparedStatement.executeUpdate() > 0){
                preparedStatement = connection.prepareStatement("UDPATE seats SET booked=0 WHERE id=?");
                preparedStatement.setInt(1, oldSeatID);
                if(preparedStatement.execute()) {
                    preparedStatement = connection.prepareStatement("UPDATE seats SET booked=1 WHERE space=?");
                    preparedStatement.setString(1, object.getSeatNumber());

                    if (preparedStatement.execute()) {
                        return true;
                    }
                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return false;
    }

    @Override
    public boolean create(Reservation object) {
        try{
            Seat seat = seatRepository.get(object.getSeatNumber());
            if(seat == null){
                return false;
            }

            preparedStatement = connection.prepareStatement("INSERT INTO reservation(movie_id, seat_id, date, time, customer_id) " +
                    "VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, object.getMovie().getId());
            preparedStatement.setInt(2, seat.getId());
            preparedStatement.setString(3, object.getDate().toString());
            preparedStatement.setInt(4, object.getTime());
            preparedStatement.setString(5, object.getCustomer());

            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return false;
    }
}
