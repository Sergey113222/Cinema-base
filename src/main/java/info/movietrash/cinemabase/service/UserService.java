package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> findUsers();

    UserDto findUserById(Long id);

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);
}
