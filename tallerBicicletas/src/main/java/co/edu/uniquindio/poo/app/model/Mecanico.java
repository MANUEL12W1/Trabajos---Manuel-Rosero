package co.edu.uniquindio.poo.app.model;

public class Mecanico {
    // Metodos
    private String nombre;
    private double tarifaPorHora;

    // Relaciones

    private Cliente cliente;

    // Constructor

    public Mecanico(String nombre, double tarifaPorHora) {
        this.nombre = nombre;
        this.tarifaPorHora = tarifaPorHora;

    }
    // Sets y Gets

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTarifaPorHora() {
        return this.tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
// To String
    @Override
    public String toString() {
        return "Mecanico{" +
                "nombre='" + nombre + '\'' +
                ", tarifaPorHora=" + tarifaPorHora +
                ", cliente=" + cliente +
                '}';
    }
}


