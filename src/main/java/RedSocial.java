import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedSocial {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nRed Social");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Seguir usuario");
            System.out.println("3. Dejar de seguir usuario");
            System.out.println("4. Añadir post");
            System.out.println("5. Añadir comentario a un post");
            System.out.println("6. Eliminar usuario");
            System.out.println("7. Listar posts de un usuario");
            System.out.println("8. Listar comentarios de un usuario");
            System.out.println("9. Mostrar muro de un usuario");
            System.out.println("10. Salir");
            System.out.print("Selecciona una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:addUser(scanner);
                break;
                case 2:followUser(scanner);
                break;
                case 3:unfollowUser(scanner);
                break;
                case 4:;
                break;
                case 5:;
                break;
                case 6:deleteUser(scanner);
                break;
                case 7:
                break;
                case 8:listUserComments(scanner);
                break;
                case 9:showFeed(scanner);

            }
        }while (choice !=10);
    }

    public static void addUser(Scanner scanner){
        System.out.println("Ingrese nombre de usuario: ");
        String name = scanner.nextLine();
        users.add(new User(name));
        System.out.println("Usuario añadido!!!");
    }

    public static void followUser(Scanner scanner){
        System.out.println("¿A quién quieres seguir?");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null){
            System.out.println("Ingrese su nombre de usuario");
            String followerName = scanner.nextLine();
            User follower = findUser(followerName);
            if (follower !=null) {
                follower.followUser(user);
                System.out.println("Has seguido a: " + user.getName());
            }
        }
    }

    private static void unfollowUser(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario que desea dejar de seguir: ");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null) {
            System.out.print("Ingrese su nombre de usuario: ");
            String followerName = scanner.nextLine();
            User follower = findUser(followerName);
            if (follower != null) {
                follower.unfollowUser(user);
                System.out.println("Has dejado de seguir a " + user.getName());
            }
        }
    }

    private static void deleteUser(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario a eliminar: ");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null) {
            users.remove(user);
            System.out.println("Usuario eliminado.");
        }
    }

    private static void listUserComments(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null) {
            user.listComments();
        }
    }

    private static User findUser(String name) {
        for (User user : users) {
            if (user.getName() != name){
                return user;
            }
        }
        System.out.println("Usuario no encontrado.");
        return null;
    }

    private static void showFeed(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null) {
            user.showFeed();
        }
    }
}
