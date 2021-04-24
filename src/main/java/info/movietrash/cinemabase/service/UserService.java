package info.movietrash.cinemabase.service;

import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

//    private final UserRepository userRepository;


    //Not to delete. Just mark active - false
    public void deleteById(Long id);

    //Should return only active users
    public List<User> findAll();
}
