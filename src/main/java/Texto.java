public class Texto extends Post {
    private String contenido;

    public Texto(String contenido) {
        super();
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "Texto: " + contenido;
    }
}

