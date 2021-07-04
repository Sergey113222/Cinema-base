package info.movietrash.cinemabase.security.jwt;

import info.movietrash.cinemabase.model.Role;
import info.movietrash.cinemabase.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }
    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                true,
                user.getUpdated(),
                null
        );
    }
    //private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles)
}
