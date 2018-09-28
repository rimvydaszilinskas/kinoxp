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
import org.springframework.web.bind.annotation.RequestParam;

public class CustomerController {
    private Repository<Customer> customerRepository;
    private Repository<Movie> movieRepository;
    private Repository<Reservation> reservationRepository;

    public CustomerController(){
        customerRepository = new CustomerRepository();
        movieRepository = new MovieRepository();
        reservationRepository= new ReservationRepository();
    }

    @GetMapping("/")
    public String home(){return "index";}

    @GetMapping("/movieList")
    public String movieList(){return "movieList";}

    @GetMapping("/booking")
    public String booking(){
        return "booking";
    }

/*    @PostMapping("/booking")
    public String booking(){

        return "booking";
    }*/
}