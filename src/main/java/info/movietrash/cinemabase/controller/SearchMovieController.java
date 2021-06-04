package info.movietrash.cinemabase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.dto.SearchDto;
import info.movietrash.cinemabase.service.SearchService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/search")
public class SearchMovieController {

    private final SearchService searchService;
    @PostMapping
    public List<MovieDto> searchMoviesByName(@RequestBody SearchDto dto) throws JsonProcessingException {
        return searchService.searchMoviesByName(dto);
    }
    @GetMapping(value = "/popular")
    public List<MovieDto> searchMoviesPopular() throws JsonProcessingException {
        return searchService.searchMoviesPopular();
    }
    @GetMapping(value = "/latest")
    public MovieDto searchMovieLatest() throws JsonProcessingException {
        return searchService.searchMovieLatest();
    }
}
