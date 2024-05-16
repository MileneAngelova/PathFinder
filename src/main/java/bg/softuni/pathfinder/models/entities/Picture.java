package bg.softuni.pathfinder.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;


    @ManyToOne
    @JoinColumn(name = "rout_id")
    private Rout rout;

    public Picture() {
    }

    public Long getId() {
        return id;
    }

    public Picture setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public Rout getRout() {
        return rout;
    }

    public void setRout(Rout rout) {
        this.rout = rout;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
