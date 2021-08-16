package info.movietrash.cinemabase.converter;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Movie;

public interface MovieConverter {
    Movie toModel(MovieDto movieDto);

    MovieDto toDto(Movie movie);
}
