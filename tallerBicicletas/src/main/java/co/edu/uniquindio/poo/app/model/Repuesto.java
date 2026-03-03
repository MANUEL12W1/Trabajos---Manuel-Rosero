package co.edu.uniquindio.poo.app.model;

public class Repuesto {
    private String nombre;
    private int cantidad;
    private double costoUnitario;
    // Constructor
    public Repuesto(String nombre, int cantidad, double costoUnitario){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }
    //Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    // toString

    @Override
    public String toString() {
        return "Repuesto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
