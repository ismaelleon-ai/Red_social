import java.time.LocalDateTime;

public class Comments {
    private String text;
    private LocalDateTime date;
    private User creator;

    public Comments(String text, User creator) {
        this.text = text;
        this.date = LocalDateTime.now();
        this.creator = creator;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return creator.getName() + " comentó el " + date + ": " + text;
    }
}