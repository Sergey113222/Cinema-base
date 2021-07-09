package info.movietrash.cinemabase.service.impl;

import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.exception.ErrorMessages;
import info.movietrash.cinemabase.exception.ResourceNotFoundException;
import info.movietrash.cinemabase.model.Role;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public Long createUser(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userDto.setRole(Role.USER);
        Long registerUserDtoId = userRepository.save(userConverter.toModel(userDto)).getId();
        log.info("In createUser - user: {} successfully created", registerUserDtoId);
        return registerUserDtoId;
    }

    @Override
    public UserDto findUserByName(String username) {
        UserDto userDto = userConverter.toDto(userRepository.findByUsername(username));
        log.info("In findUserByName - user: {} successfully found by username: {}", userDto, username);
        return userDto;
    }

    @Override
    public List<UserDto> findAllUsers(Sort.Direction direction, String sortColumn) {
        List<UserDto> userDtoList = userConverter.toDtoList(userRepository.findAll(
                Sort.by(direction, sortColumn)));
        log.info("In findAll - users: {} successfully found", userDtoList.size());
        return userDtoList;
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, id)));
        log.info("In findUserById - user: {} successfully found by id: {}", user, id);
        return userConverter.toDto(user);
    }

    @Transactional
    @Override
    public void updateUser(UserDto userDto) {
        Long id = userDto.getId();
        User existed = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(String.format(ErrorMessages.RESOURCE_NOT_FOUND, id)));
        existed.setUsername(userDto.getUsername());
        existed.setPassword((userDto.getPassword()));
        log.info("In updateUser - user: {} successfully updated", existed);
        userRepository.save(existed);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
        log.info("In deleteUser successfully deleted by id: {}", id);
    }
}
