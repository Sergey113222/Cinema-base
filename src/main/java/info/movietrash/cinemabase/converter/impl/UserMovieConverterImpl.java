package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.UserMovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Genre;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMovieConverterImpl implements UserMovieConverter {

    @Override
    public UserMovie createUserMovie(User user, Movie movie, MovieDto movieDto) {
        if (ObjectUtils.allNotNull(user, movie, movieDto)) {
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

        List<Long> genresIds = userMovie.getMovie().getGenres().stream().map(Genre::getExternalId).collect(Collectors.toList());
        movieDto.setGenreIds(genresIds);

        movieDto.setPersonalRating(userMovie.getRating());
        movieDto.setPersonalNotes(userMovie.getNotes());
        return movieDto;
    }
}
