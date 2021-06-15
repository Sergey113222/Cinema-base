package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.externalId = :externalId")
    Optional<Movie> findByExternalId(Long externalId);
}
