import java.util.Scanner;
//15:21 21/11
public class App {

    public void logMenu(RedSocial redSocial) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {

            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:{
                    if (redSocial.getActiveUser()==null){
                        redSocial.logIn();
                        if (redSocial.getActiveUser()!=null){
                        mainMenu(redSocial,scanner);
                        }
                        break;
                    }
                }
                case 2: {
                    String registerName = Utils.string("Ingrese su nombre de usuario: ");
                    redSocial.registerUser(registerName);
                    mainMenu(redSocial, scanner);
                    break;
                }
                case 3: {
                    System.out.println("Saliendo...");
                    break;
                }
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public static void mainMenu (RedSocial redSocial, Scanner scanner) {

            int opcion;
            do {

                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Agregar usuario");
                System.out.println("2. Eliminar usuario");
                System.out.println("3. Seguir usuario");
                System.out.println("4. Dejar de seguir usuario");
                System.out.println("5. Agregar post");
                System.out.println("6. Agregar comentario");
                System.out.println("7. Listar posts de un usuario");
                System.out.println("8. Listar comentarios de un usuario");
                System.out.println("9. Contar comentarios de un post");
                System.out.println("10. Mostrar usuarios");
                System.out.println("11. Mostrar usuarios seguidos");
                System.out.println("12. Cerrar sesión");
                System.out.println("13. Salir");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    //Añadir usuario
                    case 1: {
                        System.out.print("Nombre del usuario:");
                        String nombreUsuarioAñadir = scanner.nextLine();
                        User user = new User(nombreUsuarioAñadir);
                        redSocial.addUsers(user);
                        break;
                    }
                    //Eliminar usuario
                    case 2: {
                        System.out.println("Elija usuario a eliminar:");
                        redSocial.showUsers();
                        String nombreUsuarioEliminar = scanner.nextLine();
                        User user = redSocial.buscarUsuario(nombreUsuarioEliminar);
                        if (user != null) {
                            redSocial.deleteUsers(user);
                            System.out.println("Usuario eliminado.");
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    }
                    //Seguir usuario
                    case 3: {
                        System.out.print("¿A quién desea seguir?");
                        String nombreSeguir = scanner.nextLine();
                        User userASeguir = redSocial.buscarUsuario(nombreSeguir);

                        if (userASeguir != null) {
                            redSocial.getActiveUser().follow(userASeguir);
                            System.out.println("Ahora sigues a " + userASeguir.getName());
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    }
                    //Dejar de seguir usuario
                    case 4: {
                        System.out.print("¿A quién desea dejar de seguir?");
                        String nombreDejarSeguir = scanner.nextLine();
                        User userADejarSeguir = redSocial.buscarUsuario(nombreDejarSeguir);

                        if (userADejarSeguir != null) {
                            redSocial.getActiveUser().unfollow(userADejarSeguir);
                            System.out.println("Has dejado de seguir a " + userADejarSeguir.getName());
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    }
                    //Publicar post
                    case 5: {

                        System.out.println("Seleccione el tipo de post:");
                        System.out.println("1. Texto");
                        System.out.println("2. Imagen");
                        System.out.println("3. Video");
                        int tipoPost = scanner.nextInt();
                        scanner.nextLine();

                        switch (tipoPost) {
                            case 1:
                                System.out.print("Contenido del texto: ");
                                String contenido = scanner.nextLine();
                                Post textoPost = new Text(contenido);
                                redSocial.getActiveUser().addPost(textoPost);
                                System.out.println("Post de texto agregado.");
                                break;

                            case 2:
                                System.out.print("Título de la imagen: ");
                                String tituloImagen = scanner.nextLine();
                                System.out.print("Ancho de la imagen: ");
                                int ancho = scanner.nextInt();
                                System.out.print("Alto de la imagen: ");
                                int alto = scanner.nextInt();
                                Post imagenPost = new Image(tituloImagen, ancho, alto);
                                redSocial.getActiveUser().addPost(imagenPost);
                                System.out.println("Post de imagen agregado.");
                                break;

                            case 3:
                                System.out.print("Título del video: ");
                                String tituloVideo = scanner.nextLine();
                                System.out.print("Calidad del video: ");
                                int calidad = scanner.nextInt();
                                System.out.print("Duración en segundos: ");
                                int duracion = scanner.nextInt();
                                Post videoPost = new Video(tituloVideo, calidad, duracion);
                                redSocial.getActiveUser().addPost(videoPost);
                                System.out.println("Post de video agregado.");
                                break;

                            default:
                                System.out.println("Tipo de post no válido.");
                        }
                        break;
                    }
                    //Comentar post
                    case 6: {
                        if (redSocial.getActiveUser() != null) {
                            System.out.print("Nombre del usuario del post a comentar: ");
                            String nombreUsuarioACom = scanner.nextLine();
                            User user = redSocial.buscarUsuario(nombreUsuarioACom);

                            if (user != null) {
                                System.out.println("Seleccione el número del post:");
                                for (int i = 0; i < user.getPosts().size(); i++) {
                                    System.out.println(i + ": " + user.getPosts().get(i));
                                }
                                int postIndex = scanner.nextInt();
                                scanner.nextLine();

                                if (postIndex >= 0 && postIndex < user.getPosts().size()) {
                                    Post post = user.getPosts().get(postIndex);
                                    System.out.print("Escribe el comentario: ");
                                    String textoComentario = scanner.nextLine();
                                    Comentario comentario = new Comentario(textoComentario, redSocial.getActiveUser());
                                    post.agregarComentario(comentario);
                                    System.out.println("Comentario agregado.");
                                } else {
                                    System.out.println("Número de post no válido.");
                                }
                            } else {
                                System.out.println("Usuario no encontrado.");
                            }
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    }
                    //Listar post
                    case 7: {
                        redSocial.listPosts(redSocial.getActiveUser());
                    }
                    //Listar comentarios
                    case 8: {
                        redSocial.listComments(redSocial.getActiveUser());
                        break;
                    }
                    //Contar comentarios
                    case 9: {
                        System.out.print("¿De qué usuario quiere consultar post? ");
                        String nombreUsuarioContar = scanner.nextLine();
                        User user = redSocial.buscarUsuario(nombreUsuarioContar);

                        if (user != null) {
                            System.out.println("Seleccione el número del post:");
                            for (int i = 0; i < user.getPosts().size(); i++) {
                                System.out.println(i + ": " + user.getPosts().get(i));
                            }
                            int postIndex = scanner.nextInt();

                            if (postIndex >= 0 && postIndex < user.getPosts().size()) {
                                Post post = user.getPosts().get(postIndex);
                                System.out.println("El número de comentarios en el post es: " + post.contarComentarios());
                            } else {
                                System.out.println("Número de post no válido.");
                            }
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    }
                    break;
                    //Mostrar usuarios
                    case 10: {
                        redSocial.showUsers();
                        break;
                    }
                    //Mostrar usuarios seguidos
                    case 11: {
                        redSocial.getActiveUser().showFollowUsers();
                        break;
                    }
                    case 12: {
                        redSocial.logOut();
                        opcion=13;

                    }
                    //Salir
                    case 13: {
                        System.out.println("Saliendo...");
                        return;

                    }
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 13);

            scanner.close();
        }
    }

