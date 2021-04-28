package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
