package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.active = true and u.id = :id")
    Optional<User> findById(Long id);

}
