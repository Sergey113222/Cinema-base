package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.exception.ErrorMessage;
import info.movietrash.cinemabase.exception.ResourceNotFoundException;
import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userConverter.toModel(userDto);
        user.setActive(true);
        userRepository.save(user);
        userDto = userConverter.toDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> findUsers() {
        List<User> users = userRepository.findAll();
        Stream<User> onlyActive = users.stream().filter((p) -> p.getActive() == true);
        List<User> activeUsers = onlyActive.collect(Collectors.toList());
        return activeUsers.stream().map(userConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND, id)));
        UserDto userDto = userConverter.toDto(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Long id = userDto.getId();
        User existed = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND, id)));
        existed.setUsername(userDto.getUsername());
        existed.setPassword((userDto.getPassword()));
        userRepository.save(existed);
        userDto = userConverter.toDto(existed);
        return userDto;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND, id)));
        user.setActive(false);
        userRepository.save(user);
    }
}
