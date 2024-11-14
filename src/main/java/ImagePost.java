import java.time.LocalDateTime;
import java.util.List;

public class ImagePost extends Post{
    private String title;
    private int lenght, height;

    public ImagePost(LocalDateTime date, List<Comments> comments) {
        super(date, comments);
    }

    public ImagePost(LocalDateTime date, List<Comments> comments, String title, int height, int lenght) {
        super(date, comments);
        this.title = title;
        this.height = height;
        this.lenght = lenght;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
