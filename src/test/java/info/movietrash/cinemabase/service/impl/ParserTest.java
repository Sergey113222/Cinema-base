package info.movietrash.cinemabase.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.MovieDto;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
@SpringBootTest
public class ParserTest {

    private static String str = "response.json";

    @Test
    public void readFromFile() throws IOException {
        String actualStr = readTestResourceFile(str);
        System.out.println(actualStr);
        Assert.assertNotNull(actualStr);
    }

    protected String readTestResourceFile(String fileName) throws IOException {
        URL resource = this.getClass().getClassLoader().getResource(fileName);
        return FileUtils.readFileToString(new File(resource.getPath()));

    }

    @Test
    public void parseResponseToClass() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String actualStr = readTestResourceFile(str);
        JsonNode responseBody = objectMapper.readTree(actualStr);
        JsonNode resultsMassive = responseBody.path("results");
        List<MovieDto> jsonToMoviesList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
        });
        jsonToMoviesList.forEach(System.out::println);

        Assert.assertNotNull(jsonToMoviesList);
    }
}
