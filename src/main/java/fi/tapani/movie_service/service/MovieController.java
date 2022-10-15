package fi.tapani.movie_service.service;

import fi.tapani.movie_service.model.Movie;
import fi.tapani.movie_service.util.ResourceNotFound;
import java.util.List;
import java.util.UUID;
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

  @GetMapping("/{id}")
  public Movie getMovie(@PathVariable("id") UUID id) {
    return movieService.getMovie(id)
        .orElseThrow(ResourceNotFound::new);
  }

  @PostMapping("/add-movie")
  public Movie addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
  }

  @PostMapping("/add-movies")
  public List<Movie> addMovies(@RequestBody List<Movie> movies) {
    return movieService.addMovies(movies);
  }

}
