package info.movietrash.cinemabase.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.Profile;
import info.movietrash.cinemabase.model.Role;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserController userController;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;
    private final User user;

    {
        Profile profile = new Profile();
        profile.setAge(20);
        profile.setGender("M");

        user = new User();
        user.setUsername("Maxim");
        user.setPassword("G113222");
        user.setActive(true);
        user.setRole(Role.ADMIN);
        user.setProfile(profile);
    }

    @BeforeEach
    void setUp() {
        userRepository.save(user);
    }

    @Test
    void findUserById() throws Exception {
        Long id = user.getId();
        String responseAsString = mockMvc
                .perform(get("/api/v1/users/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        UserDto foundUserDto = objectMapper.readValue(responseAsString, UserDto.class);
        System.out.println(foundUserDto);
    }

    @Test
    @Sql(scripts = "classpath:/sql/user.sql", executionPhase = BEFORE_TEST_METHOD)
    void findAllUsersSorted() throws Exception {
        String responseAsString = mockMvc
                .perform(get("/api/v1/users")
                        .param("sortDirection", "DESC")
                        .param("sortColumn", "username"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<User> foundUsers = objectMapper.readValue(responseAsString, new TypeReference<>() {
        });
        assertFalse(foundUsers.isEmpty());

    }

    @Test
    void deleteUserById() throws Exception {
        Long id = user.getId();
        mockMvc.perform(delete("/api/v1/users/" + id))
                .andExpect(status().isOk());
        assertFalse(userRepository.findById(id).isPresent());
    }
}