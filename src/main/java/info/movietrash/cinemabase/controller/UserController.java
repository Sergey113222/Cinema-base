package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/users")
@Api(tags = "controller-only-for-ADMIN")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    @RolesAllowed("ADMIN")
    @ApiOperation(value = "Find User by id")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping(value = "/param")
    @RolesAllowed("ADMIN")
    @ApiOperation(value = "Find all sorted Users (choose type of sort(ASC/DESC) and by which column to sort)")
    public List<UserDto> findAllUsersSorted(
            @RequestParam Sort.Direction direction,
            @RequestParam String sortColumn) {
        return userService.findAllUsers(direction, sortColumn);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMIN")
    @ApiOperation(value = "Delete User by id")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}

