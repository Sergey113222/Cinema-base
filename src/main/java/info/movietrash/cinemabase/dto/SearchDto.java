package info.movietrash.cinemabase.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {
    private String query;
    private String lang = "en-US";
    private boolean includeAdult;

}
