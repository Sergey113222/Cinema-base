package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.AuthenticationResponseDto;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final UserService userService;

    @PostMapping(value = "/new")
    public void register(@RequestBody @Valid UserDto userDto) {
        userService.createUser(userDto);
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody @Valid UserDto userDto) {
        userService.updateUser(userDto);
    }

}
