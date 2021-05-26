package info.movietrash.cinemabase.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "movie")
public class Movie extends BaseModel {

    @Column(name = "title")
    private String title;
    @Column(name = "poster")
    private String poster;
    @Column(name = "premier_date")
    private Date premierDate;
    @Column(name = "imdb")
    private Double Imdb;
    @Column(name = "description")
    private String description;
    @Column(name = "is_adult")
    private Boolean adult;
    @Column(name = "external_id")
    private Long externalId;

    //это мы добавили две строчки
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "movie_genre",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserMovie> userMovies;

}
