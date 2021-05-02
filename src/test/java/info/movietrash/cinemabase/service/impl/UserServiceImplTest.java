//package info.movietrash.cinemabase.service.impl;
//
//import info.movietrash.cinemabase.converter.UserConverter;
//import info.movietrash.cinemabase.dto.UserDto;
//import info.movietrash.cinemabase.model.User;
//import info.movietrash.cinemabase.repository.UserRepository;
//import info.movietrash.cinemabase.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class UserServiceImplTest {
//
//    @Autowired
//    UserConverter userConverter;
//
//    UserService userService;
//    UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        userRepository = mock(UserRepository.class);
//        userService = new UserServiceImpl(userRepository, userConverter);
//    }
//
//    @Test
//    void should_invoke_userRepository_save_when_createUser() {
//        userService.createUser(new UserDto(null, "SSS", "S123456"));
//
//        verify(userRepository).save(any());
//    }
//
//    @Test
//    public void should_returns_users_whentest_findUsers() {
//        List<User> allUsers = new ArrayList<>();
//        allUsers.add(new User(5L, "SSS", "S123456", null, true, null, null));
//        allUsers.add(new User(1L, "DDD", "S123456", null, true, null, null));
//        allUsers.add(new User(3L, "AAA", "S123456", null, true, null, null));
//        when(userRepository.findAll()).thenReturn(allUsers);
//
//        List<UserDto> allDtoUsers = userService.findUsers();
//
//        verify(userRepository).findAll();
//    }
//
//    @Test
//    public void should_returns_user_by_id() {
//        User user = new User(5L, "SSS", "S123456", null, true, null, null);
//        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
//
//        UserDto userDto = userService.findUserById(user.getId());
//
//        assertNotNull(userDto.getId());
//        assertEquals(user.getUsername(), userDto.getUsername());
//    }
//
//    @Test
//    void userById_not_found_exception_thrown() {
//        assertThrows(ResourceNotFoundException.class, () -> userService.findUserById(1L));
//    }
//
//    @Test
//    void returns_user_dto_with_updated_name_when_updateUser() {
//        UserDto update = new UserDto(null, "NEW_SSS", "S123456");
//        User user = new User(5L, "SSS", "S123456", null, true, null, null);
//        when(userRepository.findById(update.getId())).thenReturn(Optional.of(user));
//        when(userRepository.save(user)).thenReturn(new User(update.getId(), update.getUsername(), update.getPassword(), null, true, null, null));
//        UserDto expectedUserDto = new UserDto(user.getId(), update.getUsername(), update.getPassword());
//
//        Optional<User> found = userRepository.findById(5L);
//        assertTrue(found.isPresent());
//        assertEquals(update.getUsername(), found.get().getUsername());
//        assertEquals(update.getPassword(), found.get().getPassword());
//    }
//
//    @Test
//    void if_user_not_found_when_update_exception_thrown() {
//        UserDto sourceUserDto = new UserDto(1L, "SSS", "S123456");
//
//        assertThrows(ResourceNotFoundException.class, () -> userService.updateUser(sourceUserDto));
//    }
//
//    @Test
//    void should_delete_user_by_id() {
//        User user = new User(1L, "SSS", "S123456", null, true, null, null);
//        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
//
//        userService.deleteUser(1L);
//        assertEquals(false, user.getActive());
//    }
//
//    @Test
//    void if_user_not_found_when_delete_then_exception_thrown() {
//        assertThrows(ResourceNotFoundException.class, () -> userService.deleteUser(1L));
//    }
//}