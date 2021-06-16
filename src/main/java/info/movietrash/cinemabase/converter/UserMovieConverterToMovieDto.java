package info.movietrash.cinemabase.converter;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.UserMovie;

public interface UserMovieConverterToMovieDto {
    MovieDto convertUserMovieToMovieDto(UserMovie userMovie);
}
