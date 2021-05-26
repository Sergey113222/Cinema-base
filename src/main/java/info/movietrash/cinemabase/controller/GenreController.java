package info.movietrash.cinemabase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.movietrash.cinemabase.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/genre")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public void reloadData() throws JsonProcessingException {
        genreService.reloadData();
    }
}
