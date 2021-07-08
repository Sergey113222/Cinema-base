package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.dto.SearchDto;
import info.movietrash.cinemabase.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/search")
public class SearchMovieController {

    private final SearchService searchService;

    @PostMapping
    public List<MovieDto> searchMoviesByName(@RequestBody @Valid SearchDto dto) {
        return searchService.searchMoviesByName(dto);
    }

    @GetMapping(value = "/popular")
    public List<MovieDto> searchMoviesPopular() {
        return searchService.searchMoviesPopular();
    }

    @GetMapping(value = "/latest")
    public MovieDto searchMovieLatest() {
        return searchService.searchMovieLatest();
    }
}
