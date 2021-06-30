package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.externalId = :externalId")
    Optional<Genre> findByExternalId(Long externalId);

    @Query("select g from Genre g where g.externalId IN :genreExternalIds")
    List<Genre> findAllByExternalId(@Param("genreExternalIds") List<Long> genreExternalIds);
}
