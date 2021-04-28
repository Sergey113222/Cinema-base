package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Genre, Long> {
}