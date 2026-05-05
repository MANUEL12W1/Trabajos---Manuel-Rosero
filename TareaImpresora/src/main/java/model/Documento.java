package model;

public class Documento {
    private String titulo;
    private String contenido;
    private TipoDocumento tipo;

    public Documento(String titulo, String contenido, TipoDocumento tipo) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}