package info.movietrash.cinemabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "poster")
    private String poster;
    @Column(name = "year")
    private String year;
    @Column(name = "rating_imdb")
    private Double ratingImdb;
    @Column(name = "description")
    private String description;
    @Column(name = "is_adult")
    private Boolean adult;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
