package info.movietrash.cinemabase.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_movie")
public class UserMovie extends BaseModel {

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "notes")
    private String notes;
    @Column(name = "viewed")
    private boolean viewed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
