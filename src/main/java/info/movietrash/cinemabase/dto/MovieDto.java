package info.movietrash.cinemabase.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
@JsonAutoDetect
public class MovieDto {

    private Long id;
    private String title;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("release_date")
    private Date releaseDate;
    @JsonProperty("vote_average")
    private Double voteAverage;
    private String overview;
    private Boolean adult;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

}
