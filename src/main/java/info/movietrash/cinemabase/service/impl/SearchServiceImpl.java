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

    private final RestTemplate restTemplate;

    public SearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<MovieDto> searchMoviesByName(SearchDto dto) throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.themoviedb.org")
                .path("/3/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", dto.getQuery())
                .queryParam("language", dto.getLang())
                .build()
                .toUri();

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String moviesJson = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode responseBody = objectMapper.readTree(moviesJson);
        JsonNode resultsMassive = responseBody.path("results");
        List<MovieDto> jsonToMoviesList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
        });
        return jsonToMoviesList;
    }

    @Override
    public List<MovieDto> searchMoviesPopular() throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.themoviedb.org")
                .path("/3/movie/popular")
                .queryParam("api_key", apiKey)
                .build()
                .toUri();

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String moviesJson = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode responseBody = objectMapper.readTree(moviesJson);
        JsonNode resultsMassive = responseBody.path("results");
        List<MovieDto> jsonToMoviesList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
        });
        return jsonToMoviesList;
    }

    @Override
    public MovieDto searchMovieLatest() throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.themoviedb.org")
                .path("/3/movie/latest")
                .queryParam("api_key", apiKey)
                .build()
                .toUri();

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String moviesJson = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MovieDto movieDto = objectMapper.readValue(moviesJson, MovieDto.class);
        return movieDto;
    }
}
