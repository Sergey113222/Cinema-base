package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Long createUser(UserDto userDto);

    UserDto findUserById(Long id);

    void updateUser(UserDto userDto);

    void deleteUser(Long id);
}
