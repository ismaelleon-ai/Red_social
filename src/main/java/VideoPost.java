import java.time.LocalDateTime;
import java.util.List;

public class VideoPost extends Post{
    private String title;
    private String quality;
    private int duration;

    public VideoPost(LocalDateTime date, List<Comments> comments) {
        super(date, comments);
    }

    public VideoPost(LocalDateTime date, List<Comments> comments, String title, int duration, String quality) {
        super(date, comments);
        this.title = title;
        this.duration = duration;
        this.quality = quality;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
