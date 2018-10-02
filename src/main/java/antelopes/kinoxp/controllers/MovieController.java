package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Movie;
import antelopes.kinoxp.repositories.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

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

    @PostMapping(URL_PATH + "/delete")
    public String delete(Model model, @RequestParam("id")String id){
        try{
            int movieID = Integer.parseInt(id);
            model.addAttribute("was_deleted", movieRepository.delete(movieID));
        }catch (Exception ex){
            model.addAttribute("was_deleted", false);
        }
        return "movies/updateMovieList";
    }

    @PostMapping(URL_PATH + "/update")
    public String update(@ModelAttribute Movie movie){
        movieRepository.update(movie);
        return "movies/updateMovieList";
    }
}
