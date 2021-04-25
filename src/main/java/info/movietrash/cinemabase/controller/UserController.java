package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserDto user) {
        userService.save(user);
    }

    @GetMapping
    public List<User> findUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PutMapping
    public void updateUser(@RequestBody UserDto user) {
        //check not to change username
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}

