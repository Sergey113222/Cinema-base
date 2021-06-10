package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/favourite")
public class UserMovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Long> addToFavouriteMovie(@RequestBody MovieDto movieDto) {
        Long createdMovieDtoId = movieService.addToFavouriteMovies(movieDto);
        return ResponseEntity.status(CREATED).body(createdMovieDtoId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findFavouriteMovieById(@PathVariable("id") Long id) {
        MovieDto movieDto = movieService.fetchFavouriteMovieById(id);
        return ResponseEntity.ok().body(movieDto);
    }

    @PutMapping
    public ResponseEntity<MovieDto> updateFavouriteMovie(@RequestBody MovieDto movieDto, @RequestParam Long userMovieId) {
        movieService.updateFavouriteMovie(movieDto, userMovieId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> deleteFavouriteMovie(@PathVariable("id") Long id) {
        movieService.deleteFavouriteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
