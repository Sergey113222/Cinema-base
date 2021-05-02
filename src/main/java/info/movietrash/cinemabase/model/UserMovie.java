package info.movietrash.cinemabase.model;

import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_movie")
public class UserMovie extends BaseModel {

    @Column(name = "rating")
    private Integer rating;
    @Column(name = "notes")
    private String notes;
    @Column(name = "viewed")
    private boolean viewed;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
