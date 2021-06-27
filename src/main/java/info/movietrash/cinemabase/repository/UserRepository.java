package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.active = true and u.id = :id")
    Optional<User> findById(Long id);

    @Modifying
    @Query("update User u set u.active = false where u.id = :id")
    void updateUser(@Param("id") Long id);

    Page<User> findAll(Pageable pageable);

}
