import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedSocial {
    private List<User> users;
    private User activeUser;

    public RedSocial() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsuarios() {
        return users;
    }

    public void setUsuarios(List<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void popularRedSocial(){
        User user1 = new User("aperez");
        user1.addPost(new Text("¡Hola mundo!"));
        user1.addPost(new Text("S.O.S."));
        addUsers(user1);
        User user2 = new User("alojo");
        user2.addPost(new Text("Prueba número 11201223013."));
        addUsers(user2);
        User user3 = new User("agarcia");
        user3.addPost(new Image("Amanecer en la montaña", 1920, 1080));
        user3.addPost(new Video("Tutorial de Java", 720, 300));
        addUsers(user3);
    }

    public void logOut(){
        if (activeUser != null) {
            System.out.println("Adiós, " + activeUser.getName() + ". Has cerrado sesión correctamente.");
           activeUser=null;
        } else {
            System.out.println("No hay ningún usuario autenticado.");

        }
    }

    public void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu nombre de usuario para iniciar sesión: ");
        String nombreUsuario = scanner.nextLine();

        for (User user : users) {
            if (user.getName().equalsIgnoreCase(nombreUsuario)) {
                System.out.println("¡Bienvenido, " + user.getName() + "!");
                activeUser= user;
            }
        }if (activeUser==null){
            System.out.println("El usuario \"" + nombreUsuario + "\" no está registrado. Por favor, regístrate o intenta con otro nombre.");
        }

    }

    public void registerUser(String registrationName){
        if (buscarUsuario(registrationName)==null){
            User newUser = new User(registrationName);
            users.add(newUser);
            activeUser=newUser;
        }else {
            System.out.println("Este usuario ya existe");
        }
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios en la red social.");
        } else {
            System.out.println("Lista de usuarios:");
            for (User user : users) {
                System.out.println("- " + user.getName());
            }
        }
    }

    public void addUsers(User user) {
        if (existeUsuario(user.getName())) {
            System.out.println("El usuario \"" + user.getName() + "\" ya existe en la red social. No se puede añadir.");
        } else {
            users.add(user);

        }
    }

    public boolean existeUsuario(String nombre) {
        for (User user : users) {
            if (user.getName().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void deleteUsers(User user) {
        users.remove(user);
    }

    public User buscarUsuario(String nombre) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(nombre)) {
                return user;
            }
        }
        return null;
    }

    public void listPosts(User user) {
        for (Post post : user.getPosts()) {
            System.out.println(post);
        }
    }

    public void listarComentarios(User userAutenticado) {

        for (User user : users) {
            for (Post post : user.getPosts()) {
                for (Comentario comentario : post.getComments()) {
                    if (comentario != null) {
                        System.out.println("- En el post: " + post + " de " + user.getName() + " -> " + comentario.getText());

                    } else {
                        System.out.println("No realizó ningún comentario.");
                    }
                }
            }
        }
    }
}