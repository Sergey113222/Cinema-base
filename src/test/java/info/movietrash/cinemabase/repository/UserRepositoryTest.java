package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Sql(scripts = "classpath:/sql/user.sql", executionPhase = BEFORE_TEST_METHOD)
    @Test
    void findByEmail() {
        //Given
        String email = "k-grine@mail.ru";
        //when
        Optional<User> optionalUser = userRepository.findByEmail(email);
        //then
        assertTrue(optionalUser.isPresent());
        User user = optionalUser.get();
        assertEquals("k-grine@mail.ru", user.getProfile().getEmail());
    }
}