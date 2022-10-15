package fi.tapani.movie_service.repository;

import fi.tapani.movie_service.model.Movie;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

  Optional<Movie> findByName(String movieName);
}
