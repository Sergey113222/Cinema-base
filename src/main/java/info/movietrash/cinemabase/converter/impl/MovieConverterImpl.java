package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.exception.ErrorMessages;
import info.movietrash.cinemabase.exception.ResourceNotFoundException;
import info.movietrash.cinemabase.model.Genre;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.repository.GenreRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MovieConverterImpl implements MovieConverter {

    private final GenreRepository genreRepository;

    @Override
    public Movie toModel(@NonNull MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setExternalId(movieDto.getExternalMovieId());
        movie.setPoster(movieDto.getPosterPath());
        movie.setPremierDate(movieDto.getReleaseDate());
        movie.setImdb(movieDto.getVoteAverage());
        movie.setDescription(movieDto.getOverview());
        movie.setAdult(movieDto.getAdult());


        List<Long> genreExternalIds = movieDto.getGenreIds();
        List<Genre> genres = new ArrayList<>();
        for (Long genreExternalId : genreExternalIds) {
            genres.add(genreRepository.findByExternalId(genreExternalId).orElseThrow(() ->
                    new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, genreExternalId))));
        }
        movie.setGenres(genres);
        return movie;
    }

    @Override
    public MovieDto toDto(@NonNull Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setExternalMovieId(movie.getExternalId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setPosterPath(movie.getPoster());
        movieDto.setReleaseDate(movie.getPremierDate());
        movieDto.setVoteAverage(movie.getImdb());
        movieDto.setOverview(movie.getDescription());
        movieDto.setAdult(movie.getAdult());

        List<Genre> genres = movie.getGenres();
        List<Long> genresIds = new ArrayList<>();
        for (Genre genre : genres) {
            genresIds.add(genre.getExternalId());
        }

        movieDto.setGenreIds(genresIds);
        return movieDto;
    }
}
