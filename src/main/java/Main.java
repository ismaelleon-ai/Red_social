import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RedSocial redSocial = new RedSocial();
        Usuario usuario1 = new Usuario("ileon");
        redSocial.agregarUsuario(usuario1);
        Usuario usuario2 = new Usuario("banon");
        redSocial.agregarUsuario(usuario2);
        Usuario usuario3 = new Usuario("amartin");
        redSocial.agregarUsuario(usuario3);

        boolean salir = false;
        while (!salir) {
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
            System.out.println("11. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                //Seguir usuario
                case 1:{
                    System.out.print("Nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    redSocial.agregarUsuario(new Usuario(nombreUsuario));
                    System.out.println("Usuario agregado.");
                    break;
                }
                //Dejar de seguir usuario
                case 2:{
                    System.out.println("Elija usuario a eliminar: ");
                    redSocial.mostrarUsuarios();
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = redSocial.buscarUsuario(nombreUsuario);
                    if (usuario != null) {
                        redSocial.eliminarUsuario(usuario);
                        System.out.println("Usuario eliminado.");
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Seguir usuario
                case 3:{
                    System.out.print("¿A quién desea seguir? ");
                    String nombreASeguir = scanner.nextLine();
                    Usuario usuario = redSocial.buscarUsuario(nombreASeguir);

                    if (usuario != null) {
                        usuario.seguir(usuario);
                        System.out.println("Ahora sigues a " + nombreASeguir);
                    } else {
                        System.out.println("Usuario no encontrados.");
                    }
                    break;
                }
                //Dejar de seguir usuario
                case 4:{
                    System.out.print("¿A quién va a dejar de seguir? ");
                    usuario1.mostrarUsuariosSeguidos();
                    String dejarDeSeguir = scanner.nextLine();
                    Usuario usuario = redSocial.buscarUsuario(dejarDeSeguir);

                    if (dejarDeSeguir != null) {
                        usuario.dejarDeSeguir(dejarDeSeguir);
                        System.out.println("Ha dejado de seguir a " + dejarDeSeguir);
                    } else {
                        System.out.println("Uno o ambos usuarios no encontrados.");
                    }
                    break;
                }
                //Publicar post
                case 5:{
                    System.out.print("Nombre del usuario que publica el post: ");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = redSocial.buscarUsuario(nombreUsuario);

                    if (usuario != null) {
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
                            usuario.agregarPost(textoPost);
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
                            usuario.agregarPost(imagenPost);
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
                            usuario.agregarPost(videoPost);
                            System.out.println("Post de video agregado.");
                            break;

                        default:
                            System.out.println("Tipo de post no válido.");
                    }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                break;
                }
                //Comentar post
                case 6:{
                    System.out.print("Nombre del usuario del post a comentar: ");
                    String nombrePropietario = scanner.nextLine();
                    Usuario propietario = redSocial.buscarUsuario(nombrePropietario);

                    if (propietario != null) {
                        System.out.print("Nombre del usuario del post a comentar: ");
                        String nombreUsuario = scanner.nextLine();
                        Usuario usuario = redSocial.buscarUsuario(nombreUsuario);

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
                            Comentario comentario = new Comentario(textoComentario,propietario);
                            post.agregarComentario(comentario);
                            System.out.println("Comentario agregado.");
                        } else {
                            System.out.println("Número de post no válido.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                }else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Listar post
                case 7:{
                    System.out.print("¿De qué usuario quiere ver post?");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = redSocial.buscarUsuario(nombreUsuario);
                    if (usuario != null) {
                        redSocial.listarPosts(usuario);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Listar comentarios
                case 8:{
                    System.out.print("¿De qué usuario quiere ver comentarios?");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = redSocial.buscarUsuario(nombreUsuario);
                    if (usuario != null) {
                        redSocial.listarComentarios(usuario);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Contar comentarios
                case 9:{
                    System.out.print("¿De qué usuario quiere consultar post? ");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = redSocial.buscarUsuario(nombreUsuario);

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
                //Mostrar usuarios
                case 10:{
                    redSocial.mostrarUsuarios();
                    break;
                }
                case 11:{
                    salir = true;
                    break;
                }
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
