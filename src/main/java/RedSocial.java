import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedSocial {
    private List<Usuario> usuarios;

    public RedSocial() {
        this.usuarios = new ArrayList<>();
    }

    public void popularRedSocial(){
        Usuario usuario1 = new Usuario("aperez");
        usuario1.agregarPost(new Texto("¡Hola mundo!"));
        usuario1.agregarPost(new Texto("S.O.S."));
        agregarUsuario(usuario1);
        Usuario usuario2 = new Usuario("alojo");
        usuario2.agregarPost(new Texto("Prueba número 11201223013."));
        agregarUsuario(usuario2);
        Usuario usuario3 = new Usuario("agarcia");
        usuario3.agregarPost(new Imagen("Amanecer en la montaña", 1920, 1080));
        usuario3.agregarPost(new Video("Tutorial de Java", 720, 300));
        agregarUsuario(usuario3);
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
        if (existeUsuario(usuario.getNombre())) {
            System.out.println("El usuario \"" + usuario.getNombre() + "\" ya existe en la red social. No se puede añadir.");
        } else {
            usuarios.add(usuario);

        }
    }

    public boolean existeUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
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

    public void listarComentarios(Usuario usuarioAutenticado) {

        for (Usuario usuario : usuarios) {
            for (Post post : usuario.getPosts()) {
                for (Comentario comentario : post.getComentarios()) {
                    if (comentario != null) {
                        System.out.println("- En el post: " + post + " de " + usuario.getNombre() + " -> " + comentario.getTexto());

                    } else {
                        System.out.println("No realizó ningún comentario.");
                    }
                }
            }
        }
    }
}