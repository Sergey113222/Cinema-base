package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class UserConverterImplTest {

    private UserConverter userConverter;
    private ProfileConverterImpl profileConverter;
    private User user;
    private UserDto userDto;

    {
        user = new User();
        user.setId(1l);
        user.setUsername("Max");
        user.setPassword("G113212");
        user.setActive(true);
    }

    {
        userDto = new UserDto();
        userDto.setId(2l);
        userDto.setUsername("Maxim");
        userDto.setPassword("G113222");
    }

    @BeforeEach
    void setUp() {
        profileConverter = mock(ProfileConverterImpl.class);
        userConverter = new UserConverterImpl(profileConverter);
    }

    @Test
    void toModel() {
        User convertUser = userConverter.toModel(userDto);
        assertEquals(userDto.getUsername(), convertUser.getUsername());
        assertEquals(userDto.getPassword(), convertUser.getPassword());
    }

    @Test
    void toDto() {
        UserDto convertUserDto = userConverter.toDto(user);
        assertNotNull(convertUserDto.getId());
        assertEquals(convertUserDto.getUsername(), user.getUsername());
        assertEquals(convertUserDto.getPassword(), user.getPassword());
    }

    @Test
    void toDtoList() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        List<UserDto> convertUserDtoList = userConverter.toDtoList(userList);
        UserDto convertUserDto = convertUserDtoList.get(0);
        assertNotNull(convertUserDto.getId());
        assertEquals(convertUserDto.getUsername(), user.getUsername());
        assertEquals(convertUserDto.getPassword(), user.getPassword());
    }
}