package antelopes.kinoxp.repositories;

import antelopes.kinoxp.repositories.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Repository<T> {
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;
    protected Connection connection;

    public Repository(){
        try {
            connection = Database.getConnection();
        } catch (SQLException err){
            System.out.println("Failed to connect. Err: " + err.getSQLState());
        }
    }

    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract boolean delete(T object);

    public abstract boolean delete(int id);

    public abstract boolean update(T object);

    public abstract boolean create(T object);

}
