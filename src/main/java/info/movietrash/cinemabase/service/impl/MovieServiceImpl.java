package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.exception.ErrorMessages;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.MovieRepository;
import info.movietrash.cinemabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;

    @Override
    public Long addMovie(MovieDto movieDto) {
        return movieRepository.save(movieConverter.toModel(movieDto)).getId();
    }

    @Override
    public MovieDto fetchMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, Movie.class, id)));
        MovieDto movieDto = movieConverter.toDto(movie);
        return movieDto;
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        Long id = movieDto.getId();
        Movie existed = movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, User.class, id)));
        existed.setTitle(movieDto.getTitle());
        existed.setPoster(movieDto.getPosterPath());
        existed.setPremierDate(movieDto.getReleaseDate());
        existed.setImdb(movieDto.getVoteAverage());
        existed.setDescription(movieDto.getOverview());
        existed.setAdult(movieDto.getAdult());
        movieRepository.save(existed);
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, User.class, id)));
        movieRepository.delete(movie);
    }
}
