package info.movietrash.cinemabase.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
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

}
