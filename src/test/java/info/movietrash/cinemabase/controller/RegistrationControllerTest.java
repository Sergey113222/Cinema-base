package info.movietrash.cinemabase.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.ProfileDto;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserController userController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void register() throws Exception {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setAvatar("zxc");
        profileDto.setAbout("good men very very ");
        profileDto.setEmail("maxim@mail.ru");
        profileDto.setFirstName("Maxim");
        profileDto.setLastName("Ivanov");
        profileDto.setAge(20);
        profileDto.setGender("M");
        profileDto.setRegion("ru");
        profileDto.setLanguage("en");

        UserDto userDto = new UserDto();
        userDto.setId(7L);
        userDto.setUsername("Maxim");
        userDto.setPassword("Gr113222");
        userDto.setRole(Role.ROLE_ADMIN);
        userDto.setProfileDto(profileDto);

        String responseAsString = mockMvc
                .perform(post("/registration/new")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}