package info.movietrash.cinemabase.security;

import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import info.movietrash.cinemabase.security.jwt.JwtUser;
import info.movietrash.cinemabase.security.jwt.JwtUserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("In loadByEmail - user with email: {} successfully loaded", email);
        return jwtUser;
    }
}
