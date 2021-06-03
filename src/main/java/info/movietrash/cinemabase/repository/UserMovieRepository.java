package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {
}
