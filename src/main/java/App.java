import java.util.Scanner;
//15:21 21/11
public class App {

    public void logMenu() {
        Scanner scanner = new Scanner(System.in);
        RedSocial redSocial = new RedSocial();

        int opcion;
        do {

            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1: {
                    String nombreLogin = Utils.string("Hola");
                    redSocial.logIn(nombreLogin);
                    mainMenu(redSocial,scanner);
                }
                case 2: {
                    System.out.println("Saliendo...");
                    break;
                }
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 2);
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
                        Usuario usuario = new Usuario(nombreUsuarioAñadir);
                        redSocial.agregarUsuario(usuario);
                        break;
                    }
                    //Eliminar usuario
                    case 2: {
                        System.out.println("Elija usuario a eliminar:");
                        redSocial.mostrarUsuarios();
                        String nombreUsuarioEliminar = scanner.nextLine();
                        Usuario usuario = redSocial.buscarUsuario(nombreUsuarioEliminar);
                        if (usuario != null) {
                            redSocial.eliminarUsuario(usuario);
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
                        Usuario usuarioASeguir = redSocial.buscarUsuario(nombreSeguir);

                        if (usuarioASeguir != null) {

                            System.out.println("Ahora sigues a " + usuarioASeguir.getNombre());
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    }
                    //Dejar de seguir usuario
                    case 4: {
                        System.out.print("¿A quién desea dejar de seguir?");
                        String nombreDejarSeguir = scanner.nextLine();
                        Usuario usuarioADejarSeguir = redSocial.buscarUsuario(nombreDejarSeguir);

                        if (usuarioADejarSeguir != null) {
                            redSocial.getActiveUser().dejarDeSeguir(usuarioADejarSeguir);
                            System.out.println("Has dejado de seguir a " + usuarioADejarSeguir.getNombre());
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
                                Post textoPost = new Texto(contenido);
                                redSocial.getActiveUser().agregarPost(textoPost);
                                System.out.println("Post de texto agregado.");
                                break;

                            case 2:
                                System.out.print("Título de la imagen: ");
                                String tituloImagen = scanner.nextLine();
                                System.out.print("Ancho de la imagen: ");
                                int ancho = scanner.nextInt();
                                System.out.print("Alto de la imagen: ");
                                int alto = scanner.nextInt();
                                Post imagenPost = new Imagen(tituloImagen, ancho, alto);
                                redSocial.getActiveUser().agregarPost(imagenPost);
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
                                redSocial.getActiveUser().agregarPost(videoPost);
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
                            Usuario usuario = redSocial.buscarUsuario(nombreUsuarioACom);

                            if (usuario != null) {
                                System.out.println("Seleccione el número del post:");
                                for (int i = 0; i < usuario.getPosts().size(); i++) {
                                    System.out.println(i + ": " + usuario.getPosts().get(i));
                                }
                                int postIndex = scanner.nextInt();
                                scanner.nextLine();

                                if (postIndex >= 0 && postIndex < usuario.getPosts().size()) {
                                    Post post = usuario.getPosts().get(postIndex);
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
                        System.out.print("¿De qué usuario quiere ver post?");
                        String nombreUsuarioListarPost = scanner.nextLine();
                        Usuario usuario = redSocial.buscarUsuario(nombreUsuarioListarPost);
                        if (usuario != null) {
                            redSocial.listarPosts(usuario);
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    }
                    //Listar comentarios
                    case 8: {
                        redSocial.listarComentarios(redSocial.getActiveUser());
                        break;
                    }
                    //Contar comentarios
                    case 9: {
                        System.out.print("¿De qué usuario quiere consultar post? ");
                        String nombreUsuarioContar = scanner.nextLine();
                        Usuario usuario = redSocial.buscarUsuario(nombreUsuarioContar);

                        if (usuario != null) {
                            System.out.println("Seleccione el número del post:");
                            for (int i = 0; i < usuario.getPosts().size(); i++) {
                                System.out.println(i + ": " + usuario.getPosts().get(i));
                            }
                            int postIndex = scanner.nextInt();

                            if (postIndex >= 0 && postIndex < usuario.getPosts().size()) {
                                Post post = usuario.getPosts().get(postIndex);
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
                        redSocial.mostrarUsuarios();
                        break;
                    }
                    //Mostrar usuarios seguidos
                    case 11: {
                        redSocial.getActiveUser().mostrarUsuariosSeguidos();
                        break;
                    }
                    case 12: {
                        redSocial.logOut();
                        break;
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

