package info.movietrash.cinemabase.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface GenreService {

    void reloadData() throws JsonProcessingException;
}
