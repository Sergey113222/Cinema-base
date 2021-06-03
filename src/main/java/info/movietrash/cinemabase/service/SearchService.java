package info.movietrash.cinemabase.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.dto.SearchDto;

import java.util.List;

public interface SearchService {

    List<MovieDto> searchMoviesByName(SearchDto dto) throws JsonProcessingException;

    List<MovieDto> searchMoviesPopular() throws JsonProcessingException;

    MovieDto searchMovieLatest() throws JsonProcessingException;
}
