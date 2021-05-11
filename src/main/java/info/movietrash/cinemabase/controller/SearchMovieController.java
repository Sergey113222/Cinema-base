package info.movietrash.cinemabase.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.MovieDto;
import info.movietrash.cinemabase.dto.SearchDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchMovieController {

    @Value("${themoviedb.ord.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public SearchMovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public List<MovieDto> searchMovies(@RequestBody SearchDto dto) {

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.themoviedb.org")
                .path("/3/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", dto.getQuery())
                .queryParam("language", dto.getLang())
                .build()
                .toUri();

        try {

            RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            String moviesJson = response.getBody();

            JSONObject jsonObj = new JSONObject(moviesJson);

            JSONArray ja_data = jsonObj.getJSONArray("results");
            for (int i = 0; i < jsonObj.length(); i++) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                List<MovieDto> jsonToMoviesList = objectMapper.readValue(moviesJson, new TypeReference<List<MovieDto>>() {
                });
                jsonToMoviesList.forEach(System.out::println);
            }

            return null;

        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }
}
