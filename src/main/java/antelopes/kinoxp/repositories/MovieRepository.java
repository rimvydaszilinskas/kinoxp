package antelopes.kinoxp.repositories;

import java.util.List;

public class MovieRepository extends Repository<Movie> {
    public MovieRepository() {
        super();
    }

    @Override
    public Movie get(int id) {
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM movie WHERE id=?")
        }
        return null;
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }

    @Override
    public boolean delete(Movie object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Movie object) {
        return false;
    }

    @Override
    public boolean create(Movie object) {
        return false;
    }
}
