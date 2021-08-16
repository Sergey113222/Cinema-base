package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.service.MovieService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "adds a movie to an authenticated user (you can leave your rating and feedback)")
    public ResponseEntity<Long> addToFavouriteMovie(@RequestBody @Valid MovieDto movieDto) {
        Long createdMovieDtoId = movieService.addToFavouriteMovies(movieDto);
        return ResponseEntity.status(CREATED).body(createdMovieDtoId);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "finds the user's favorite movie")
    public ResponseEntity<MovieDto> findFavouriteMovieById(@PathVariable("id") @Min(1) Long id) {
        MovieDto movieDto = movieService.fetchFavouriteMovieById(id);
        return ResponseEntity.ok().body(movieDto);
    }

    @PutMapping
    @ApiOperation(value = "update the user's favorite movie (rating and feedback)")
    public ResponseEntity<MovieDto> updateFavouriteMovie(@RequestBody @Valid MovieDto movieDto, @RequestParam @Min(1) Long userMovieId) {
        movieService.updateFavouriteMovie(movieDto, userMovieId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete the user's favorite movie")
    public ResponseEntity<MovieDto> deleteFavouriteMovie(@PathVariable("id") @Min(1) Long id) {
        movieService.deleteFavouriteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
