package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.externalId = :externalId")
    Optional<Genre> findByExternalId(Long externalId);
}
