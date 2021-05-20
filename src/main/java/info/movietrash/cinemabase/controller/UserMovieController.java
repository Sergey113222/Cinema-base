package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/favourite")
public class UserMovieController {

    private final MovieService movieService;

    @PostMapping
    public Long addMovie(@RequestBody MovieDto movieDto) {
        return movieService.addMovie(movieDto);
    }

    @GetMapping("/{id}")
    public MovieDto findMovieById(@PathVariable("id") Long id) {
        return movieService.fetchMovieById(id);
    }

    @PutMapping
    public void updateMovie(@RequestBody MovieDto movieDto) {
        movieService.updateMovie(movieDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
    }
}
