package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final UserService userService;

    @PostMapping(value = "/new")
    public Long register(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
    }

}
