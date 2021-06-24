package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserConverterImplTest {

    @Autowired
    private UserConverter userConverter;

    @Test
    void toDtoCheckNpeHandling() {
        UserDto userDto = userConverter.toDto(null);
        assertNull(userDto);
    }

    //todo add positive test
}