package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.exception.ErrorMessages;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;
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
        User user = null;
        Movie movie = null;
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        Optional<Movie> movieOptional = Optional.ofNullable(movieRepository.findByExternalId(movieDto.getExternalId()));
        if (movieOptional.isPresent()) {
            movie = movieOptional.get();
            movieRepository.save(movie);
        }


        UserMovie userMovie = new UserMovie();
        userMovie.setUser(user);
        userMovie.setMovie(movie);

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
