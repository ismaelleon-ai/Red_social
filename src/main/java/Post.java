import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Post {
    private Date date;
    private List<Comentario> comments;

    public Post() {
        this.date = new Date();
        this.comments = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    public List<Comentario> getComments() {
        return comments;
    }

    public void agregarComentario(Comentario comentario) {
        comments.add(comentario);
    }

    public void eliminarComentario(Comentario comentario) {
        comments.remove(comentario);
    }

    public int contarComentarios() {
        return comments.size();
    }
}
