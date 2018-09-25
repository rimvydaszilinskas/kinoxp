package antelopes.kinoxp.repositories;

import antelopes.kinoxp.models.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerRepository extends Repository<Customer> {
    public CustomerRepository() {
        super();
    }

    @Override
    public Customer get(int id) {
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE id=?");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return new Customer(resultSet.getInt("id"), resultSet.getString("name"));
            }
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE id=?");
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
        return null;
    }

    @Override
    public boolean delete(Customer object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Customer object) {
        return false;
    }

    @Override
    public boolean create(Customer object) {
        return false;
    }
}
