package info.movietrash.cinemabase.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SearchDto {
    @NotBlank
    @Pattern(regexp = "\\w{1,64}", message = "query should be between [1-64]")
    private String query;
    private String lang = "en-US";
    private boolean includeAdult;
}
