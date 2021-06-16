package info.movietrash.cinemabase.converter;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;

public interface UserMovieConverterFromUserAndMovieAndMovieDto {
    UserMovie createUserMovie(User user, Movie movie, MovieDto movieDto);
}
