package info.movietrash.cinemabase.service.impl;


import info.movietrash.cinemabase.converter.DirectionConverter;
import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.security.jwt.JwtTokenProvider;
import info.movietrash.cinemabase.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserConverter userConverter;
    private UserService userService;
    private UserRepository userRepository;
    private DirectionConverter directionConverter;
    private JwtTokenProvider jwtTokenProvider;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final User user;
    private final UserDto userDto;

    {
        user = new User();
        user.setId(2L);
        user.setUsername("Maxim");
        user.setPassword("G113222");
        user.setActive(true);
    }

    {
        userDto = new UserDto();
        userDto.setId(2L);
        userDto.setUsername("Maxim");
        userDto.setPassword("G113222");
    }

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userConverter = mock(UserConverter.class);
        bCryptPasswordEncoder= mock(BCryptPasswordEncoder.class);
        jwtTokenProvider = mock(JwtTokenProvider.class);
        userService = new UserServiceImpl(userRepository, userConverter, bCryptPasswordEncoder,  jwtTokenProvider);
    }

    @Test
    void findUserById() {
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        when(userConverter.toDto(any())).thenReturn(userDto);
        UserDto userDto = userService.findUserById(user.getId());

        assertNotNull(userDto.getId());
        assertEquals(user.getUsername(), userDto.getUsername());
    }


    @Test
    void updateUser() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userConverter.toDto(any())).thenReturn(userDto);
        UserDto userDto = userService.findUserById(user.getId());
        userService.updateUser(userDto);

        verify(userRepository).save(any());
    }

    @Test
    void deleteUserById() {
        userService.deleteUser(user.getId());
        verify(userRepository).deleteUser(user.getId());
    }
}


