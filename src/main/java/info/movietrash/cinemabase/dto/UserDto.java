package info.movietrash.cinemabase.dto;

import info.movietrash.cinemabase.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String username;
    @NotEmpty
    @NotNull
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
    private String password;
    @NotNull
    private Role role;
    private ProfileDto profileDto;

    //временно для запихивание пользователя вручную (пока нет секьюрити)
    public UserDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
