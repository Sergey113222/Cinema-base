package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Movie_genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Movie_genre, Long> {
}
