package info.movietrash.cinemabase.service.impl;


import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    UserConverter userConverter;
    UserService userService;
    UserRepository userRepository;
    User user;

    {
        user = new User();
        user.setId(2l);
        user.setUsername("Maxim");
        user.setPassword("G113222");
        user.setActive(true);
    }

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userConverter = mock(UserConverter.class);
        userService = new UserServiceImpl(userRepository, userConverter);
    }

    @Test
    void createUser() {
        when(userRepository.save(any())).thenReturn(user);
        userService.createUser(new UserDto(null, "SSS", "S123456"));

        verify(userRepository).save(any());
        assertNotNull(user.getId());
    }

    @Test
    void findUserById() {
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        when(userConverter.toDto(any())).thenReturn(new UserDto(1L, "Maxim", "G113222"));
        UserDto userDto = userService.findUserById(user.getId());

        assertNotNull(userDto.getId());
        assertEquals(user.getUsername(), userDto.getUsername());
    }


    @Test
    void updateUser() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userConverter.toDto(any())).thenReturn(new UserDto(2L, "Maxim", "G113222"));
        UserDto userDto = userService.findUserById(user.getId());
        userService.updateUser(userDto);

        verify(userRepository).save(any());
    }

    @Test
    void deleteUserById() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userService.deleteUser(2L);

        assertEquals(false, user.getActive());
    }

    @Test
    void if_user_not_found_when_delete_then_exception_thrown() {
        assertThrows(IllegalArgumentException.class, () -> userService.deleteUser(3L));
    }
}


