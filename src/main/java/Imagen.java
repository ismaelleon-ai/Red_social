public class Imagen extends Post {
    private String titulo;
    private int ancho;
    private int alto;

    public Imagen(String titulo, int ancho, int alto) {
        super();
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Imagen: " + titulo + " (" + ancho + "x" + alto + ")";
    }
}
