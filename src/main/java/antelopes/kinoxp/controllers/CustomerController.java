package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Customer;
import antelopes.kinoxp.models.Movie;
import antelopes.kinoxp.models.Reservation;
import antelopes.kinoxp.repositories.CustomerRepository;
import antelopes.kinoxp.repositories.MovieRepository;
import antelopes.kinoxp.repositories.Repository;
import antelopes.kinoxp.repositories.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController{

    private Repository<Customer> customerRepository;
    private Repository<Movie> movieRepository;
    private Repository<Reservation> reservationRepository;

    public CustomerController(){
        customerRepository = new CustomerRepository();
        movieRepository = new MovieRepository();
        reservationRepository= new ReservationRepository();
    }

    @GetMapping("/customers/movieList")
    public String movieList(Model model) {

        model.addAttribute("movies", movieRepository.getAll());
        return "customers/movieList";
    }

    @GetMapping("/booking")
    public String booking(@RequestParam("id")int movieId,@ModelAttribute Customer customer, @ModelAttribute Reservation reservation)
    {

        movieRepository.get(movieId);
        customerRepository.create(customer);
        reservationRepository.create(reservation);
        return "booking";
    }
}
