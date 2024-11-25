import java.util.Date;

public class Comentario {
    private String text;
    private Date date;
    private User author;

    public Comentario(String text, User author) {
        this.text = text;
        this.date = new Date();
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return author.getName() + ": " + text;
    }
}
