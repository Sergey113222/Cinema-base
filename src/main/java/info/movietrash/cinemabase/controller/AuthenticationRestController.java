package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.AuthenticationRequestDto;
import info.movietrash.cinemabase.dto.AuthenticationResponseDto;
import info.movietrash.cinemabase.model.Role;
import info.movietrash.cinemabase.security.jwt.JwtAuthenticationException;
import info.movietrash.cinemabase.security.jwt.JwtTokenProvider;
import info.movietrash.cinemabase.security.jwt.JwtUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "/login")
    public AuthenticationResponseDto login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            String password = requestDto.getPassword();
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            JwtUser principal = (JwtUser) authenticate.getPrincipal();

            List<? extends GrantedAuthority> simpleGrantedAuthorities = new ArrayList<>(principal.getAuthorities());
            Role role = Role.valueOf(simpleGrantedAuthorities.get(0).toString());
            List<Role> roleList = new ArrayList<>();
            roleList.add(role);

            String token = jwtTokenProvider.createToken(username, roleList);

            return new AuthenticationResponseDto(username, token);
        } catch (JwtAuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
