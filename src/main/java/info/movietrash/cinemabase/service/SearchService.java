package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.dto.SearchDto;

import java.util.List;

public interface SearchService {

    List<MovieDto> searchMoviesByName(SearchDto dto);

    List<MovieDto> searchMoviesPopular();

    MovieDto searchMovieLatest();
}
