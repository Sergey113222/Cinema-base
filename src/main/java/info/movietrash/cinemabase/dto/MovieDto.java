package info.movietrash.cinemabase.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@JsonAutoDetect
public class MovieDto {

    private Long id;
    private String title;
    private String poster_path;
    private String release_date;
    private Double vote_average;
    private String overview;
    private Boolean adult;
    List<Integer> genre_ids;

}
