package info.movietrash.cinemabase.security.jwt;

import info.movietrash.cinemabase.model.Role;
import info.movietrash.cinemabase.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getActive().equals(true),
                user.getUpdated(),
                mapToGrantedAuthorities(new ArrayList<>(Collections.singleton(user.getRole())))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
    }
}
