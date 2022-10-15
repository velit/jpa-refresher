package fi.tapani.movie_service.service;

import fi.tapani.movie_service.model.Movie;
import fi.tapani.movie_service.reps.MovieRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Movie addMovie(String name, int year) {
    Movie newMovie = new Movie(name, year);
    return movieRepository.save(newMovie);
  }

  public Movie addMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public List<Movie> addMovies(List<Movie> movies) {
    return movieRepository.saveAll(movies);
  }

  public Optional<Movie> getMovie(UUID id) {
    return movieRepository.findById(id);
  }
}
