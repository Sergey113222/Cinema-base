package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final UserService userService;

    @PostMapping(value = "/new")
    public ResponseEntity<Long> register(@RequestBody @Valid UserDto userDto) {
        Long createdUserDtoId = userService.createUser(userDto);
        return ResponseEntity.status(CREATED).body(createdUserDtoId);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto) {
        userService.updateUser(userDto);
        return ResponseEntity.noContent().build();
    }

}
