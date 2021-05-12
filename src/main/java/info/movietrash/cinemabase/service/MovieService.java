package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.dto.MovieDto;

public interface MovieService {
    Long addMovie(MovieDto movieDto);

    MovieDto fetchMovieById(Long id);

    void updateMovie(MovieDto movieDto);

    void deleteMovie(Long id);
}
