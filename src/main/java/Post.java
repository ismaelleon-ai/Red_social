import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Post {
    private Date fecha;
    private List<Comentario> comentarios;

    public Post() {
        this.fecha = new Date();
        this.comentarios = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public void eliminarComentario(Comentario comentario) {
        comentarios.remove(comentario);
    }

    public int contarComentarios() {
        return comentarios.size();
    }
}
