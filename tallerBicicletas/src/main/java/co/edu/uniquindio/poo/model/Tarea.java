package co.edu.uniquindio.poo.model;

public class Tarea {
    private String nombre;
    private double costo;
    private String codigo;
    private Orden ownedByOrden;

    public Tarea(String nombre, double costo, String codigo, Orden ownedByOrden) {
        this.nombre = nombre;
        this.costo = costo;
        this.codigo = codigo;
        this.ownedByOrden = ownedByOrden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Orden getOwnedByOrden() {
        return ownedByOrden;
    }

    public void setOwnedByOrden(Orden ownedByOrden) {
        this.ownedByOrden = ownedByOrden;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", codigo='" + codigo + '\'' +
                ", ownedByOrden=" + ownedByOrden +
                '}';
    }
}
