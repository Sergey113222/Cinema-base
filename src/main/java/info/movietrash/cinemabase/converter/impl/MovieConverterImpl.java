package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Movie;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MovieConverterImpl implements MovieConverter {
    @Override
    public Movie toModel(@NonNull MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setExternalId(movieDto.getExternalId());
        movie.setPoster(movieDto.getPosterPath());
        movie.setPremierDate(movieDto.getReleaseDate());
        movie.setImdb(movieDto.getVoteAverage());
        movie.setDescription(movieDto.getOverview());
        movie.setAdult(movieDto.getAdult());
        //movie.setGenres(movieDto.getGenreIds());
        return movie;
    }

    @Override
    public MovieDto toDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setExternalId(movie.getExternalId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setPosterPath(movie.getPoster());
        movieDto.setReleaseDate(movie.getPremierDate());
        movieDto.setVoteAverage(movie.getImdb());
        movieDto.setOverview(movie.getDescription());
        movieDto.setAdult(movie.getAdult());
        //movieDto.setGenreIds(movie.getGenres());
        return movieDto;
    }
}
