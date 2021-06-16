package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") @Min(1) Long id) {
        UserDto userDto = userService.findUserById(id);
        return ResponseEntity.ok().body(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUserById(@PathVariable("id") @Min(1) Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}

