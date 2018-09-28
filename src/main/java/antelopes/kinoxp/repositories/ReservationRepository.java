package antelopes.kinoxp.repositories;

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
            preparedStatement = connection.prepareStatement("SELECT * FROM reservations WHERE id=?");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
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
