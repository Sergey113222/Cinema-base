package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.UserMovieConverterToMovieDto;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.UserMovie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMovieConverterToMovieDtoImpl implements UserMovieConverterToMovieDto {
    @Override
    public MovieDto convertUserMovieToMovieDto(UserMovie userMovie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setExternalMovieId(userMovie.getMovie().getExternalId());
        movieDto.setTitle(userMovie.getMovie().getTitle());
        movieDto.setPosterPath(userMovie.getMovie().getPoster());
        movieDto.setReleaseDate(userMovie.getMovie().getPremierDate());
        movieDto.setVoteAverage(userMovie.getMovie().getImdb());
        movieDto.setOverview(userMovie.getMovie().getDescription());
        movieDto.setAdult(userMovie.getMovie().getAdult());
        //movieDto.setGenreIds(userMovie.getMovie().getGenres());
        movieDto.setPersonalRating(userMovie.getRating());
        movieDto.setPersonalNotes(userMovie.getNotes());
        return movieDto;
    }
}
