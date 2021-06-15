package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;
import info.movietrash.cinemabase.repository.MovieRepository;
import info.movietrash.cinemabase.repository.UserMovieRepository;
import info.movietrash.cinemabase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MovieServiceImplTest {

    UserMovieRepository userMovieRepository;
    MovieRepository movieRepository;
    UserRepository userRepository;
    MovieServiceImpl movieService;
    MovieConverter movieConverter;
    UserMovie userMovie;
    User user;
    Movie movie;


    {
        userMovie = new UserMovie();
        userMovie.setId(1L);
        userMovie.setRating(9);
        userMovie.setNotes("it is my favourite movie!!!!");
        userMovie.setViewed(true);
        userMovie.setUser(new User());
        userMovie.setMovie(new Movie());
    }

    {
        user = new User();
        user.setId(2l);
        user.setUsername("Maxim");
        user.setPassword("G113222");
    }

    {
        movie = new Movie();
        movie.setId(3L);
        movie.setExternalId(2569L);
        movie.setTitle("Matrix");
    }

    @BeforeEach
    void setUp() {
        movieRepository = mock(MovieRepository.class);
        userRepository = mock(UserRepository.class);
        userMovieRepository = mock(UserMovieRepository.class);
        movieService = new MovieServiceImpl(movieRepository, userMovieRepository, movieConverter, userRepository);
    }

    @Test
    void addToFavouriteMovies() {
        MovieDto movieDto = new MovieDto();
        movieDto.setExternalMovieId(2569L);
        movieDto.setPersonalRating(9);
        movieDto.setPersonalNotes("YoO!!!");

        when(userRepository.findById(any())).thenReturn(Optional.ofNullable(user));
        when(movieRepository.findByExternalId(any())).thenReturn(Optional.ofNullable(movie));
        UserMovie userMovie = new UserMovie();
        userMovie.setId(55L);
        when(userMovieRepository.save(any())).thenReturn(userMovie);
        movieService.addToFavouriteMovies(movieDto);
        assertNotNull(userMovie.getId());
    }

    @Test
    void fetchFavouriteMovieById() {
        when(userMovieRepository.findById(any())).thenReturn(Optional.of(userMovie));
        MovieDto movieDto = movieService.fetchFavouriteMovieById(userMovie.getId());

        assertNotNull(userMovie.getId());
        assertEquals(userMovie.getRating(), movieDto.getPersonalRating());
        assertEquals(userMovie.getNotes(), movieDto.getPersonalNotes());
        verify(userMovieRepository).findById(any());
    }

    @Test
    void updateFavouriteMovie() {
        when(userMovieRepository.findById(userMovie.getId())).thenReturn(Optional.of(userMovie));
        MovieDto movieDto = movieService.fetchFavouriteMovieById(userMovie.getId());
        movieService.updateFavouriteMovie(movieDto, userMovie.getId());

        verify(userMovieRepository).save(any());
    }

    @Test
    void deleteFavouriteMovie() {
        when(userMovieRepository.findById(userMovie.getId())).thenReturn(Optional.of(userMovie));
        movieService.deleteFavouriteMovie(1l);

        verify(userMovieRepository).delete(userMovie);
    }
}