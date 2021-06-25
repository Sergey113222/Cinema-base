package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.UserMovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Genre;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMovieConverterImpl implements UserMovieConverter {

    @Override
    public UserMovie createUserMovie(User user, Movie movie, MovieDto movieDto) {
        if ((user == null) || (movie == null) || (movieDto == null)) {
            return null;
        }
        UserMovie userMovie = new UserMovie();
        userMovie.setUser(user);
        userMovie.setMovie(movie);
        userMovie.setRating(movieDto.getPersonalRating());
        userMovie.setNotes(movieDto.getPersonalNotes());
        return userMovie;
    }

    @Override
    public MovieDto convertUserMovieToMovieDto(UserMovie userMovie) {
        if (userMovie == null) {
            return null;
        }
        MovieDto movieDto = new MovieDto();
        movieDto.setExternalMovieId(userMovie.getMovie().getExternalId());
        movieDto.setTitle(userMovie.getMovie().getTitle());
        movieDto.setPosterPath(userMovie.getMovie().getPoster());
        movieDto.setReleaseDate(userMovie.getMovie().getPremierDate());
        movieDto.setVoteAverage(userMovie.getMovie().getImdb());
        movieDto.setOverview(userMovie.getMovie().getDescription());
        movieDto.setAdult(userMovie.getMovie().getAdult());

        List<Long> genresIds = new ArrayList<>();
        for (Genre genre : userMovie.getMovie().getGenres()) {
            genresIds.add(genre.getExternalId());
        }
        movieDto.setGenreIds(genresIds);

        movieDto.setPersonalRating(userMovie.getRating());
        movieDto.setPersonalNotes(userMovie.getNotes());
        return movieDto;
    }
}
