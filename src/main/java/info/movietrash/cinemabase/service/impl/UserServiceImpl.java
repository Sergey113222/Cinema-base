package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.exception.ErrorMessages;
import info.movietrash.cinemabase.exception.ResourceNotFoundException;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Transactional
    @Override
    public Long createUser(UserDto userDto) {
        return userRepository.save(userConverter.toModel(userDto)).getId();
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userConverter.toDtoList(userRepository.findAll(Sort.by(Sort.Direction.ASC, "username")));
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, User.class, id)));
        return userConverter.toDto(user);
    }

    @Transactional
    @Override
    public void updateUser(UserDto userDto) {
        Long id = userDto.getId();
        User existed = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, User.class, id)));
        existed.setUsername(userDto.getUsername());
        existed.setPassword((userDto.getPassword()));
        userRepository.save(existed);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.updateUser(id);
    }
}
