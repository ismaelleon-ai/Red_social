import java.util.Date;

public class Comentario {
    private String texto;
    private Date fecha;
    private Usuario propietario;

    public Comentario(String texto, Usuario propietario) {
        this.texto = texto;
        this.fecha = new Date();
        this.propietario = propietario;
    }

    public String getTexto() {
        return texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    @Override
    public String toString() {
        return propietario.getNombre() + ": " + texto;
    }
}
