package info.movietrash.cinemabase.converter;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;

import java.util.List;

public interface UserConverter {
    User toModel(UserDto userDto);

    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> userList);
}
