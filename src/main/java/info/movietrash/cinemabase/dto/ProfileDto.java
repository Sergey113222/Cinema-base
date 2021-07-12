package info.movietrash.cinemabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private String avatar;
    private String about;
    @Email(message = "Email should be valid")
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String region;
    private String language;
}
