package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/favourite")
public class UserMovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Long> addToFavouriteMovie(@RequestBody @Valid MovieDto movieDto) {
        Long createdMovieDtoId = movieService.addToFavouriteMovies(movieDto);
        return ResponseEntity.status(CREATED).body(createdMovieDtoId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findFavouriteMovieById(@PathVariable("id") @Min(1) Long id) {
        MovieDto movieDto = movieService.fetchFavouriteMovieById(id);
        return ResponseEntity.ok().body(movieDto);
    }

    @PutMapping
    public ResponseEntity<MovieDto> updateFavouriteMovie(@RequestBody @Valid MovieDto movieDto, @RequestParam @Min(1) Long userMovieId) {
        movieService.updateFavouriteMovie(movieDto, userMovieId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> deleteFavouriteMovie(@PathVariable("id") @Min(1) Long id) {
        movieService.deleteFavouriteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
