package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.converter.UserMovieConverterFromUserAndMovieAndMovieDto;
import info.movietrash.cinemabase.converter.UserMovieConverterToMovieDto;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.exception.ErrorMessages;
import info.movietrash.cinemabase.exception.ResourceNotFoundException;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;
import info.movietrash.cinemabase.repository.MovieRepository;
import info.movietrash.cinemabase.repository.UserMovieRepository;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final UserMovieRepository userMovieRepository;
    private final MovieConverter movieConverter;
    private final UserRepository userRepository;
    private final UserMovieConverterToMovieDto convertUserMovieToMovieDto;
    private final UserMovieConverterFromUserAndMovieAndMovieDto userMovieConverterFromUserAndMovieAndMovieDto;

    @Transactional
    @Override
    public Long addToFavouriteMovies(MovieDto movieDto) {
        Long userId = 1L;     // in my db have created user with id = 1
        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, userId)));

        Movie movie = movieRepository
                .findByExternalId(movieDto.getExternalMovieId())
                .orElseGet(() -> movieRepository.save(movieConverter.toModel(movieDto)));

        return userMovieRepository.save(userMovieConverterFromUserAndMovieAndMovieDto.createUserMovie(user, movie, movieDto)).getId();
    }

    @Override
    public MovieDto fetchFavouriteMovieById(Long id) {
        UserMovie userMovie = userMovieRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, id)));

        return convertUserMovieToMovieDto.convertUserMovieToMovieDto(userMovie);
    }

    @Transactional
    @Override
    public void updateFavouriteMovie(MovieDto movieDto, Long userMovieId) {
        UserMovie userMovie = userMovieRepository
                .findById(userMovieId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, userMovieId)));
        userMovie.setRating(movieDto.getPersonalRating());
        userMovie.setNotes(movieDto.getPersonalNotes());
        userMovieRepository.save(userMovie);
    }

    @Transactional
    @Override
    public void deleteFavouriteMovie(Long id) {
        UserMovie userMovie = userMovieRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, id)));
        userMovieRepository.delete(userMovie);
    }
}