package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    Long createUser(UserDto userDto);

    UserDto findUserById(Long id);

    void updateUser(UserDto userDto);

    void deleteUser(Long id);

    User getUser(String authToken, String email);
}
