package info.movietrash.cinemabase.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.MovieDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ParserLatestTest {

    private static String str = "{\n" +
            "    \"id\": 828717,\n" +
            "    \"title\": \"NGHE DOC\",\n" +
            "    \"overview\": \"A look at the life and artistic perspective of contemporary Vietnamese artist Phuong Vu Manh.\",\n" +
            "    \"adult\": false,\n" +
            "    \"poster_path\": null,\n" +
            "    \"release_date\": \"\",\n" +
            "    \"vote_average\": 0.0,\n" +
            "    \"genre_ids\": null\n" +
            "}";

    @Test
    public void parseResponseLatestToClass() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MovieDto movieDto = objectMapper.readValue(str, MovieDto.class);
        System.out.println(movieDto);

        Assert.assertNotNull(movieDto);
    }
}