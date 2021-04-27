package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Role;
import info.movietrash.cinemabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    List<User> findUsersByRole(Role role);

//    @Query(value = "select*", nativeQuery = true)
//    User findSomething();

}
