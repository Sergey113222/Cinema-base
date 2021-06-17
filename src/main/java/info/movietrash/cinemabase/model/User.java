package info.movietrash.cinemabase.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseModel {

    @Column(name = "username")
    @Getter
    @Setter
    private String username;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Role role;

    @Column(name = "active")
    @Getter
    @Setter
    private Boolean active = true;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserMovie> userMovies;
}
