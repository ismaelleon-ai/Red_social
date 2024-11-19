import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Usuario> siguiendo;
    private List<Post> posts;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.siguiendo = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getSiguiendo() {
        return siguiendo;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void seguir(Usuario usuario) {
        if (!siguiendo.contains(usuario)) {
            siguiendo.add(usuario);
        }
    }

    public void dejarDeSeguir(Usuario usuario) {
        siguiendo.remove(usuario);
    }

    public void agregarPost(Post post) {
        posts.add(post);
    }

    public void eliminarPost(Post post) {
        posts.remove(post);
    }

    public void mostrarUsuariosSeguidos() {
        if (siguiendo.isEmpty()) {
            System.out.println("No sigue a ningún usuario.");
        } else {
            System.out.println("Sigue a los siguientes usuarios:");
            for (Usuario usuario : siguiendo) {
                System.out.println("- " + usuario.getNombre());
            }
        }
    }
}
