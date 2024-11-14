import java.time.LocalDateTime;
import java.util.List;

public class TextPost extends Post{

    private String content;

    public TextPost(LocalDateTime date, List<Comments> comments) {
        super(date, comments);
    }

    public TextPost(LocalDateTime date, List<Comments> comments, String content) {
        super(date, comments);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
