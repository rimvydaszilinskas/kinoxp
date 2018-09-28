package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Customer;
import antelopes.kinoxp.models.Movie;
import antelopes.kinoxp.models.Reservation;
import antelopes.kinoxp.repositories.CustomerRepository;
import antelopes.kinoxp.repositories.MovieRepository;
import antelopes.kinoxp.repositories.Repository;
import antelopes.kinoxp.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


public class MainController {
    private Repository<Customer> customerRepository;
    private Repository<Movie> movieRepository;
    private Repository<Reservation> reservationRepository;

    public MainController(){
        customerRepository = new CustomerRepository();
        movieRepository = new MovieRepository();
        reservationRepository= new ReservationRepository();
    }

    @GetMapping("/")
    public String index(){
        return "/";

    }
}