package info.movietrash.cinemabase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenreDto {
    @JsonProperty("id")
    private Long externalId;
    private String name;
}
