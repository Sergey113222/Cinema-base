package info.movietrash.cinemabase.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile extends BaseModel {

    @Column(name = "avatar")
    private String avatar;
    @Column(name = "about")
    private String about;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "region")
    private String region;
    @Column(name = "language")
    private String language;

    @OneToOne(mappedBy = "profile")
    private User user;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserMovie> userMovies;

}
