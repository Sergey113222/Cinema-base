package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.UserMovieConverterFromUserAndMovieAndMovieDto;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMovieConverterFromUserAndMovieAndMovieDtoImpl implements UserMovieConverterFromUserAndMovieAndMovieDto {

    @Override
    public UserMovie createUserMovie(User user, Movie movie, MovieDto movieDto) {
        UserMovie userMovie = new UserMovie();
        userMovie.setUser(user);
        userMovie.setMovie(movie);
        userMovie.setRating(movieDto.getPersonalRating());
        userMovie.setNotes(movieDto.getPersonalNotes());
        return userMovie;
    }
}
