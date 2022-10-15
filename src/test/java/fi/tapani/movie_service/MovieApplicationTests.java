package fi.tapani.movie_service;

import fi.tapani.movie_service.model.Movie;
import fi.tapani.movie_service.service.MovieService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
class MovieApplicationTests {

	@Autowired
	MovieService movieService;

	@BeforeAll
	public void setup() {
		movieService.addMovie("TestMovie", 2022);
	}

	@Test
	void testMovies() {
		List<Movie> movies = movieService.getAllMovies();
		Assertions.assertEquals(movies.size(), 1);
		Assertions.assertEquals(movies.get(0).getName(), "TestMovie");
		Assertions.assertEquals(movies.get(0).getYear(), 2022);
	}

	@Test
	void testFind() {
		Assertions.assertTrue(movieService.findByName("TestMovie").isPresent());
	}

}
