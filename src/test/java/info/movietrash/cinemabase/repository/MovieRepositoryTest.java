package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Sql(scripts = "classpath:/sql/movie.sql", executionPhase = BEFORE_TEST_METHOD)
    @Test
    void findByExternalId() {
        //Given
        long externalId = 8888888L;
        //when
        Optional<Movie> optionalMovie = movieRepository.findByExternalId(externalId);
        //then
        assertTrue(optionalMovie.isPresent());
        Movie movie = optionalMovie.get();
        assertEquals(8888888L, movie.getExternalId());

    }
}
