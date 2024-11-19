public class Video extends Post {
    private String titulo;
    private int calidad;
    private int duracion;

    public Video(String titulo, int calidad, int duracion) {
        super();
        this.titulo = titulo;
        this.calidad = calidad;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Video: " + titulo + " (" + calidad + "p, " + duracion + "mins)";
    }
}

