import java.util.ArrayList;
import java.util.List;

public class RedSocial {
    private List<Usuario> usuarios;

    public RedSocial() {
        this.usuarios = new ArrayList<>();
    }

    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios en la red social.");
        } else {
            System.out.println("Lista de usuarios:");
            for (Usuario usuario : usuarios) {
                System.out.println("- " + usuario.getNombre());
            }
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public void listarPosts(Usuario usuario) {
        for (Post post : usuario.getPosts()) {
            System.out.println(post);
        }
    }

    public void listarComentarios(Usuario usuario) {
        for (Post post : usuario.getPosts()) {
            for (Comentario comentario : post.getComentarios()) {
                System.out.println(comentario);
            }
        }
    }

}