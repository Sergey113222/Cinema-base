package info.movietrash.cinemabase.security;

import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.security.jwt.JwtUser;
import info.movietrash.cinemabase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final UserConverter userConverter;

    public JwtUserDetailsService(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userConverter.toModel(userService.findUserByName(username));
        if (user==null){
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        return null;
    }
}
