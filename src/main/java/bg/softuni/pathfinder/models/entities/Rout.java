package bg.softuni.pathfinder.models.entities;

import bg.softuni.pathfinder.models.enums.RoutLevelEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routs")
public class Rout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gpx_coordinates", columnDefinition = "TEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private RoutLevelEnum level;

    @Column(nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToMany
    private Set<Category> categories;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Rout() {
    }

    public Long getId() {
        return id;
    }

    public Rout setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Rout setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public RoutLevelEnum getLevel() {
        return level;
    }

    public Rout setLevel(RoutLevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Rout setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Rout setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
