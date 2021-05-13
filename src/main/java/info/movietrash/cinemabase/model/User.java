package info.movietrash.cinemabase.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User extends BaseModel {

    @Column(name = "username")
    @Getter
    @Setter
    @NotNull(message = "Name cannot be null")
    private String username;

    @Column(name = "password")
    @Getter
    @Setter
    @NotEmpty
    @NotNull
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @NotNull
    private Role role;

    @Column(name = "active")
    @Getter
    @Setter
    @AssertTrue
    private Boolean active = true;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

}
