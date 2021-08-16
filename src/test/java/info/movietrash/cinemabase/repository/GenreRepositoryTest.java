package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
class GenreRepositoryTest {
    @Autowired
    private GenreRepository genreRepository;

    @Sql(scripts = "classpath:/sql/genre.sql", executionPhase = BEFORE_TEST_METHOD)
    @Test
    void findByExternalId() {
        //Given
        long externalId = 9999999L;
        //when
        Optional<Genre> optionalGenre = genreRepository.findByExternalId(externalId);
        //then
        assertTrue(optionalGenre.isPresent());
        Genre genre = optionalGenre.get();
        assertEquals(9999999L, genre.getExternalId());

    }
}