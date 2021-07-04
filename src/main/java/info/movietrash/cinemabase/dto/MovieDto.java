package info.movietrash.cinemabase.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
@JsonAutoDetect
public class MovieDto {
    @JsonProperty("id")
    private Long externalMovieId;
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
    private List<Long> genreIds;
    @JsonProperty("personal_rating")
    @Min(value = 0, message = "Rating should be between [0-10]")
    @Max(value = 10, message = "Rating should be between [0-10]")
    private Integer personalRating;
    @Pattern(regexp = ".{2,128}", message = "Notes should be between [2-128]")
    @JsonProperty("personal_notes")
    private String personalNotes;
}
