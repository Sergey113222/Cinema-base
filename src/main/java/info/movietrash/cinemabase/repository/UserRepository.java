package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
