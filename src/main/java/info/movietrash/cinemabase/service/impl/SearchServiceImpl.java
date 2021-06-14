package info.movietrash.cinemabase.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.dto.SearchDto;
import info.movietrash.cinemabase.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

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


    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final static String JSON_NODE_STR = "results";

    public SearchServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<MovieDto> searchMoviesByName(SearchDto dto) throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(searchMovieByName)
                .queryParam("api_key", apiKey)
                .queryParam("query", dto.getQuery())
                .build()
                .toUri();

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String moviesJson = response.getBody();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode responseBody = objectMapper.readTree(moviesJson);
        JsonNode resultsMassive = responseBody.path(JSON_NODE_STR);
        List<MovieDto> jsonToMoviesList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
        });
        return jsonToMoviesList;
    }

    @Override
    public List<MovieDto> searchMoviesPopular() throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(searchMoviePopular)
                .queryParam("api_key", apiKey)
                .build()
                .toUri();

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String moviesJson = response.getBody();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode responseBody = objectMapper.readTree(moviesJson);
        JsonNode resultsMassive = responseBody.path(JSON_NODE_STR);
        List<MovieDto> jsonToMoviesList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
        });
        return jsonToMoviesList;
    }

    @Override
    public MovieDto searchMovieLatest() throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(searchMovieLatest)
                .queryParam("api_key", apiKey)
                .build()
                .toUri();

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String moviesJson = response.getBody();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MovieDto movieDto = objectMapper.readValue(moviesJson, MovieDto.class);
        return movieDto;
    }
}
