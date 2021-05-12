package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieConverterImpl implements MovieConverter {
    @Override
    public Movie toModel(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setPoster(movieDto.getPosterPath());
        movie.setPremierDate(movieDto.getReleaseDate());
        movie.setImdb(movieDto.getVoteAverage());
        movie.setDescription(movieDto.getOverview());
        movie.setAdult(movieDto.getAdult());
        //movie.setGenres(movieDto.getGenreIds());        в movie Set<Genre>  в Dto List<Integer> ???
        return movie;
    }

    @Override
    public MovieDto toDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setPosterPath(movie.getPoster());
        movieDto.setReleaseDate(movie.getPremierDate());
        movieDto.setVoteAverage(movie.getImdb());
        movieDto.setOverview(movie.getDescription());
        movieDto.setAdult(movie.getAdult());
        //movieDto.setGenreIds(movie.getGenres());    в movie Set<Genre>  в Dto List<Integer> ???
        return movieDto;
    }
}
