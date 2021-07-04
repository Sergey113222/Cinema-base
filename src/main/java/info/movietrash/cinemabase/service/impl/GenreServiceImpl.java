package info.movietrash.cinemabase.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.converter.GenreConverter;
import info.movietrash.cinemabase.dto.ExternalGenreDto;
import info.movietrash.cinemabase.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class GenreServiceImpl {

    private static final String JSON_NODE_STR = "genres";
    private static final String API_KEY = "api_key";
    private final GenreRepository genreRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final GenreConverter genreConverter;

    @Value("${themoviedb.ord.api-key}")
    private String apiKey;

    @Value("${themoviedb.ord.scheme}")
    private String scheme;

    @Value("${themoviedb.ord.host}")
    private String host;

    @Value("${themoviedb.ord.path-get-movie-genre-list}")
    private String getMovieGenreList;

    public void getGenresExternal() throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(getMovieGenreList)
                .queryParam(API_KEY, apiKey)
                .build()
                .toUri();

        if (genreRepository.count() == 0) {
            RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            String genresJson = response.getBody();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode responseBody = objectMapper.readTree(genresJson);
            JsonNode resultsMassive = responseBody.path(JSON_NODE_STR);
            List<ExternalGenreDto> jsonGenreList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<>() {
            });
            genreRepository.saveAll(genreConverter.toModel(jsonGenreList));
        }
    }
}
