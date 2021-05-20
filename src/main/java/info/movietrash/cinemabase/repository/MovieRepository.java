package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.externalId = :externalId")
    Movie findByExternalId(Long externalId);
}
