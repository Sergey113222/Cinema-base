package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.exception.ErrorMessages;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.MovieRepository;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public Long addToFavouriteMovies(MovieDto movieDto) {
        Long userId = movieDto.getUser().getId();
        Optional<User> user = userRepository.findById(userId);

        if (movieRepository.findByExternalId(movieDto.getExternalId()) != null) {
            return movieRepository.findByExternalId(movieDto.getExternalId()).getId();
        }
        Movie movie = movieConverter.toModel(movieDto);
        movie.getUsers().add(user.get());
        return movieRepository.save(movie).getId();
    }

    @Override
    public MovieDto fetchFavouriteMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, Movie.class, id)));
        MovieDto movieDto = movieConverter.toDto(movie);
        return movieDto;
    }
    @Transactional
    @Override
    public void updateFavouriteMovie(MovieDto movieDto) {
        Long id = (movieRepository.findByExternalId(movieDto.getExternalId())).getId();
        Movie existed = movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, User.class, id)));
        existed.setTitle(movieDto.getTitle());
        existed.setPoster(movieDto.getPosterPath());
        existed.setPremierDate(movieDto.getReleaseDate());
        existed.setImdb(movieDto.getVoteAverage());
        existed.setDescription(movieDto.getOverview());
        existed.setAdult(movieDto.getAdult());
        existed.setExternalId(movieDto.getExternalId());
        movieRepository.save(existed);
    }

    @Override
    public void deleteFavouriteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, Movie.class, id)));
        movieRepository.delete(movie);
    }
}
