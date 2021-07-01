package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public List<UserDto> findAllUsersSorted(
            @RequestParam Sort.Direction direction,
            @RequestParam String sortColumn) {
        return userService.findAllUsers(direction, sortColumn);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}

