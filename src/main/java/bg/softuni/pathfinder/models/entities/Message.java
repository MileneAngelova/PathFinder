package bg.softuni.pathfinder.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "text_content")
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Message setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Message setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
