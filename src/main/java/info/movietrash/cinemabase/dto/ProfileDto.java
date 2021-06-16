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
    @Size(min = 10, max = 200, message
            = "About must be between 10 and 200 characters")
    private String about;
    @Email(message = "Email should be valid")
    @Pattern(regexp = ".+@.+\\.[a-z]+")
    private String email;
    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "[\\w\\s'`]{2,64}")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "[\\w\\s'`]{2,64}")
    private String lastName;
    @NotNull
    @Min(value = 16, message = "Age should not be less than 16")
    @Max(value = 99, message = "Age should not be greater than 99")
    private Integer age;
    @NotNull
    private String gender;
    @NotNull
    private String region;
    @NotNull
    private String language;
}
