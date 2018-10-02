package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Movie;
import antelopes.kinoxp.repositories.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@Controller
public class MovieController {
    private final static String URL_PATH = "/movies";
    private MovieRepository movieRepository = new MovieRepository();

    @GetMapping(URL_PATH)
    public String displayMovies(Model model){
        model.addAttribute(movieRepository.getAll());
        return "movies/updateMovieList";
    }

    @GetMapping(URL_PATH + "/add")
    public String addMovie(){
        return "movies/addAMovie";
    }

    @PostMapping(URL_PATH + "/add")
    public String addMovie(@RequestParam("title")String title,
                           @RequestParam("genre")String genre,
                           @RequestParam("ageLimit")String ageLimit){
        int age = Integer.parseInt(ageLimit);
        Movie movie = new Movie(title, genre, age, new LinkedList<>());
        movieRepository.create(movie);
        return "employees/employees";
    }

    @PostMapping(URL_PATH + "/delete")
    public String delete(Model model, @RequestParam("id")String id){
        try{
            int movieID = Integer.parseInt(id);
            model.addAttribute("was_deleted", movieRepository.delete(movieID));
        }catch (Exception ex){
            model.addAttribute("was_deleted", false);
        }
        model.addAttribute(movieRepository.getAll());
        return "movies/updateMovieList";
    }

    @PostMapping(URL_PATH + "/update")
    public String update(Model model, @ModelAttribute Movie movie){
        model.addAttribute("updated", movieRepository.update(movie));
        model.addAttribute("movies", movieRepository.getAll());
        return "movies/updateMovieList";
    }

    @GetMapping(URL_PATH + "/get/{id}")
    public String getMovie(Model model, @PathVariable("id")String id){
        try{
            int movieID = Integer.parseInt(id);
            model.addAttribute("movie", movieRepository.get(movieID));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "movies/displayMovie";
    }
}
