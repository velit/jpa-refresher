package fi.tapani.movie_service.reps;

import fi.tapani.movie_service.model.Movie;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
