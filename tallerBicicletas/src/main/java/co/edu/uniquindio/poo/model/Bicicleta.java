package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Bicicleta {
    private String marca;
    private String serial;
    private String color;
    private Taller ownedByTaller;
    private Cliente cliente;
    private ArrayList<Orden> listaOrdenesServicio;

    public Bicicleta(String marca, String serial, String color, Taller ownedByTaller) {
        this.marca = marca;
        this.serial = serial;
        this.color = color;
        this.ownedByTaller = ownedByTaller;
        this.cliente = null;
        this.listaOrdenesServicio = new ArrayList<>();

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Taller getOwnedByTaller() {
        return ownedByTaller;
    }

    public void setOwnedByTaller(Taller ownedByTaller) {
        this.ownedByTaller = ownedByTaller;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Orden> getListaOrdenesServicio() {
        return listaOrdenesServicio;
    }

    public void setListaOrdenesServicio(ArrayList<Orden> listaOrdenesServicio) {
        this.listaOrdenesServicio = listaOrdenesServicio;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "marca='" + marca + '\'' +
                ", serial='" + serial + '\'' +
                ", color='" + color + '\'' +
                ", ownedByTaller=" + ownedByTaller +
                ", cliente=" + cliente +
                ", listaOrdenesServicio=" + listaOrdenesServicio +
                '}';
    }
}
