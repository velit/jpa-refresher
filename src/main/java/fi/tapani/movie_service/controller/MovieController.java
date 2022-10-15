package fi.tapani.movie_service.controller;

import fi.tapani.movie_service.model.Movie;
import fi.tapani.movie_service.service.MovieService;
import fi.tapani.movie_service.util.ResourceNotFound;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

  public final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @PostMapping("/add-movie")
  public Movie addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
  }

  @PostMapping("/add-movies")
  public List<Movie> addMovies(@RequestBody List<Movie> movies) {
    return movieService.addMovies(movies);
  }

  @DeleteMapping("/{id}")
  public void deleteMovie(@PathVariable("id") UUID id) {
    movieService.deleteMovie(id);
  }

  @GetMapping("/{id}")
  public Movie getMovie(@PathVariable("id") UUID id) {
    return movieService.getMovie(id)
        .orElseThrow(ResourceNotFound::new);
  }

  @GetMapping("/all-movies")
  public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
  }

  @GetMapping("find-by-name/{movieName}")
  public Movie findByName(@PathVariable("movieName") String movieName) {
    return movieService.findByName(movieName).orElseThrow(ResourceNotFound::new);
  }
}
