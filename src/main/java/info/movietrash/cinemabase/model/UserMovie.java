package info.movietrash.cinemabase.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_movie")
public class UserMovie extends BaseModel {

    @Column(name = "rating")
    private Integer rating;
    @Column(name = "notes")
    private String notes;
    @Column(name = "viewed")
    private boolean viewed;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
