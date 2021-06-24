package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.MovieConverter;
import info.movietrash.cinemabase.converter.UserMovieConverter;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.model.Genre;
import info.movietrash.cinemabase.model.Movie;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.model.UserMovie;
import info.movietrash.cinemabase.repository.MovieRepository;
import info.movietrash.cinemabase.repository.UserMovieRepository;
import info.movietrash.cinemabase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MovieServiceImplTest {

    private UserMovieRepository userMovieRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private MovieServiceImpl movieService;
    private MovieConverter movieConverter;
    private UserMovieConverter userMovieConverter;
    private final UserMovie userMovie;
    private final User user;
    private final Movie movie;
    private final Genre genre;
    private final MovieDto movieDto;

    {
        user = new User();
        user.setId(2l);
        user.setUsername("Maxim");
        user.setPassword("G113222");
    }

    {
        genre = new Genre();
        genre.setId(1L);
        genre.setExternalId(12L);
        genre.setName("Adventure");
    }

    {
        movie = new Movie();
        movie.setId(3L);
        movie.setExternalId(2569L);
        movie.setTitle("Matrix");
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);
        movie.setGenres(genres);
    }

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
        movieDto = new MovieDto();
        movieDto.setExternalMovieId(2569L);
        movieDto.setPersonalRating(9);
        movieDto.setPersonalNotes("it is my favourite movie!!!!");
    }

    @BeforeEach
    void setUp() {
        userMovieConverter = mock(UserMovieConverter.class);
        movieRepository = mock(MovieRepository.class);
        userRepository = mock(UserRepository.class);
        userMovieRepository = mock(UserMovieRepository.class);
        movieService = new MovieServiceImpl(movieRepository, userMovieRepository, movieConverter,
                userRepository, userMovieConverter);
    }

    @Test
    void addToFavouriteMovies() {
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
        when(userMovieConverter.convertUserMovieToMovieDto(any())).thenReturn(movieDto);
        MovieDto movieDto = movieService.fetchFavouriteMovieById(userMovie.getId());
        assertNotNull(userMovie.getId());
        assertEquals(userMovie.getRating(), movieDto.getPersonalRating());
        assertEquals(userMovie.getNotes(), movieDto.getPersonalNotes());
        verify(userMovieRepository).findById(any());
    }

    @Test
    void updateFavouriteMovie() {
        when(userMovieRepository.findById(userMovie.getId())).thenReturn(Optional.of(userMovie));
        when(userMovieConverter.convertUserMovieToMovieDto(any())).thenReturn(movieDto);
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