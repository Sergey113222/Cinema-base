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
    public Long addToFavouriteMovie(@RequestBody MovieDto movieDto) {
        return movieService.addToFavouriteMovies(movieDto);
    }

    @GetMapping("/{id}")
    public MovieDto findFavouriteMovieById(@PathVariable("id") Long id) {
        return movieService.fetchFavouriteMovieById(id);
    }

    @PutMapping
    public void updateFavouriteMovie(@RequestBody MovieDto movieDto) {
        movieService.updateFavouriteMovie(movieDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFavouriteMovie(@PathVariable("id") Long id) {
        movieService.deleteFavouriteMovie(id);
    }
}
