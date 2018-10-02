package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Customer;
import antelopes.kinoxp.models.Movie;
import antelopes.kinoxp.models.Reservation;
import antelopes.kinoxp.models.Snack;
import antelopes.kinoxp.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController{

    private Repository<Movie> movieRepository;
    private Repository<Reservation> reservationRepository;
    private Repository<Snack> snackRepository;

    public CustomerController(){
        movieRepository = new MovieRepository();
        reservationRepository= new ReservationRepository();
        snackRepository = new SnackRepository();
    }

    @GetMapping("/customers/movieList")
    public String movieList(Model model) {

        model.addAttribute("movies", movieRepository.getAll());
        return "customers/movieList";
    }

    @GetMapping("/booking")
    public String booking(@RequestParam("id")int movieId, Model model)
    {
        model.addAttribute("movie", movieRepository.get(movieId));
        return "customers/booking";
    }

    @PostMapping("/booking")
    public String booking(@ModelAttribute Reservation reservation){
        reservationRepository.create(reservation);
        return "redirect:/customers/movieList";

    }

    @GetMapping("/customers/snacks")
    public String snacks(Model model){
        model.addAttribute("snacks", snackRepository.getAll());
        return "customers/snacks";
    }
}
