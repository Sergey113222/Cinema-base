package info.movietrash.cinemabase.dto;

import info.movietrash.cinemabase.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private ProfileDto profileDto;

//временно для запихивание пользователя вручную (пока нет секьюрити)
    public UserDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
