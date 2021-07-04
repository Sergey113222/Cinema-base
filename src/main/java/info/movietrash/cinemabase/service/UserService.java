package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.dto.UserDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    Long createUser(UserDto userDto);

    List<UserDto> findAllUsers(Sort.Direction direction, String sortColumn);

    UserDto findUserById(Long id);

    void updateUser(UserDto userDto);

    void deleteUser(Long id);
}
