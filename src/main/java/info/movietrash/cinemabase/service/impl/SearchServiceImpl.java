package info.movietrash.cinemabase.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.dto.SearchDto;
import info.movietrash.cinemabase.exception.SearchMovieException;
import info.movietrash.cinemabase.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private static final String JSON_NODE_STR = "results";
    private static final String API_KEY = "api_key";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${themoviedb.ord.api-key}")
    private String apiKey;

    @Value("${themoviedb.ord.scheme}")
    private String scheme;

    @Value("${themoviedb.ord.host}")
    private String host;

    @Value("${themoviedb.ord.path-search-movie-by-name}")
    private String searchMovieByName;

    @Value("${themoviedb.ord.path-search-movie-popular}")
    private String searchMoviePopular;

    @Value("${themoviedb.ord.path-search-movie-latest}")
    private String searchMovieLatest;

    @Override
    public List<MovieDto> searchMoviesByName(@Valid SearchDto dto) {
        URI uri = createURI(searchMovieByName).build().toUri();
        return getMovieFromResource(uri);
    }

    @Override
    public List<MovieDto> searchMoviesPopular() {
        URI uri = createURI(searchMoviePopular).build().toUri();
        return getMovieFromResource(uri);
    }

    @Override
    public MovieDto searchMovieLatest() {
        URI uri = createURI(searchMovieLatest).build().toUri();
        try {
            RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            String moviesJson = response.getBody();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(moviesJson, MovieDto.class);
        } catch (Exception e) {
            log.error(String.format("Can't get movie from resource. %s", e.getMessage()));
            throw new SearchMovieException("Can't get movie from resource");
        }
    }

    private List<MovieDto> getMovieFromResource(URI uri) {
        try {
            RequestEntity<Object> request = new RequestEntity(HttpMethod.GET, uri);
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode responseBody = objectMapper.readTree(response.getBody());
            JsonNode resultsMassive = responseBody.path(JSON_NODE_STR);
            return objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
            });
        } catch (Exception e) {
            log.error(String.format("Can't get movie from resource. %s", e.getMessage()));
            throw new SearchMovieException("Can't get movie from resource");
        }
    }

    private UriComponentsBuilder createURI(String path) {
        return UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(path)
                .queryParam(API_KEY, apiKey);
    }
}
