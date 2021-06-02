package info.movietrash.cinemabase;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.movietrash.cinemabase.service.impl.GenreServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AllArgsConstructor
public class CinemaBaseApplication {
    private final GenreServiceImpl genreService;

    public static void main(String[] args) {
        SpringApplication.run(CinemaBaseApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initGenre() throws JsonProcessingException {
        genreService.getGenresExternal();
    }
}
