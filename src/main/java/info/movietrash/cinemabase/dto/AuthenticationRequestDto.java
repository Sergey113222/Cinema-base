package info.movietrash.cinemabase.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Details about AuthenticationRequestDto")
public class AuthenticationRequestDto {
    @ApiModelProperty(notes = "not null and unique")
    private String email;
    @ApiModelProperty(notes = "not null")
    private String password;
}
