package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Repuesto {
    private String nombre;
    private double costo;
    private int cantidad;
    private Taller ownedByTaller;
    private ArrayList<Orden> listaOrdenes;

    public Repuesto(String nombre, double costo, int cantidad, Taller ownedByTaller) {
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
        this.ownedByTaller = ownedByTaller;
        this.listaOrdenes = new ArrayList<>();
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Taller getOwnedByTaller() {
        return ownedByTaller;
    }

    public void setOwnedByTaller(Taller ownedByTaller) {
        this.ownedByTaller = ownedByTaller;
    }

    public ArrayList<Orden> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(ArrayList<Orden> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    @Override
    public String toString() {
        return "Repuesto{" +
                "nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", cantidad=" + cantidad +
                ", ownedByTaller=" + ownedByTaller +
                ", listaOrdenes=" + listaOrdenes +
                '}';
    }
}
