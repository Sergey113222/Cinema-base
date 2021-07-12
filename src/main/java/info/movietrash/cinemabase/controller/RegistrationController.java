package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.AuthenticationResponseDto;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.Role;
import info.movietrash.cinemabase.security.jwt.JwtTokenProvider;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping(value = "/new")
    public AuthenticationResponseDto register(@RequestBody @Valid UserDto userDto) {
        userDto.setRole(Role.USER);
        return userService.createUser(userDto);
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody @Valid UserDto userDto) {
        userService.updateUser(userDto);
    }

}
