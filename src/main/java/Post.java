import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {


    protected LocalDateTime date;
    private List<Comments> comments;


    public Post(LocalDateTime date, List<Comments> comments) {
        this.date = date;
        this.comments = comments;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void addComments(Comments comment) {
        comments.add(comment);
    }

    public int countComments() {
        return comments.size();
    }

    public void deleteComments(Comments comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        return "Post realizado el " + date + " con " + countComments() + " comentarios.";
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Comments> getUserComments(User user){
        List<Comments> result = new ArrayList<>();
        for (Comments comments1: comments){
            if (comments1.getCreator()==user){
                result.add(comments1);
            }
        }
        return result;
    }

}
