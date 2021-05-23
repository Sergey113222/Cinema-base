package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.dto.MovieDto;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    Long addToFavouriteMovies(MovieDto movieDto);

    MovieDto fetchFavouriteMovieById(Long id);

    void updateFavouriteMovie(MovieDto movieDto);

    void deleteFavouriteMovie(Long id);
}
