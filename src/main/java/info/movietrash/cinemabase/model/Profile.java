package info.movietrash.cinemabase.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile extends BaseModel {

    @Column(name = "avatar")
    private String avatar;
    @Column(name = "about")
    @Size(min = 10, max = 200, message
            = "About must be between 10 and 200 characters")
    private String about;
    @Column (name = "email")
    @Email(message = "Email should be valid")
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;
    @Column(name = "first_name")
    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "[a-zA-Z]")
    private String firstName;
    @Column(name = "last_name")
    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "[a-zA-Z]")
    private String lastName;
    @Column(name = "age")
    @NotNull
    @Min(value = 16, message = "Age should not be less than 16")
    @Max(value = 99, message = "Age should not be greater than 99")
    private Integer age;
    @Column(name = "gender")
    @NotNull
    private String gender;
    @Column(name = "region")
    @NotNull
    private String region;
    @Column(name = "language")
    @NotNull
    private String language;

    @OneToOne(mappedBy = "profile")
    private User user;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserMovie> userMovies;

}
