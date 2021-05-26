package info.movietrash.cinemabase.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.converter.GenreConverter;
import info.movietrash.cinemabase.converter.impl.GenreConverterImpl;
import info.movietrash.cinemabase.dto.GenreDto;
import info.movietrash.cinemabase.repository.GenreRepository;
import info.movietrash.cinemabase.service.GenreService;
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

public class GenreServiceImpl implements GenreService {
    @Value("${themoviedb.ord.api-key}")
    private String apiKey;
    @Value("${themoviedb.ord.scheme}")
    private String scheme;
    @Value("${themoviedb.ord.host}")
    private String host;

    private final GenreRepository genreRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final static String JSON_NODE_STR = "genres";

    public GenreServiceImpl(GenreRepository genreRepository, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.genreRepository = genreRepository;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void reloadData() throws JsonProcessingException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path("/3/genre/movie/list")
                .queryParam("api_key", apiKey)
                .build()
                .toUri();

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String genresJson = response.getBody();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode responseBody = objectMapper.readTree(genresJson);
        JsonNode resultsMassive = responseBody.path(JSON_NODE_STR);
        List<GenreDto> jsonGenreList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<GenreDto>>() {
        });
        GenreConverter genreConverter = new GenreConverterImpl();
        genreRepository.saveAll(genreConverter.toModel(jsonGenreList));
    }
}
