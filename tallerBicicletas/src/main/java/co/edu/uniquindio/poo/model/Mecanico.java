package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Mecanico {
    private String nombre;
    private String telefono;
    private String salario;
    private Taller ownedByTaller;
    private ArrayList<Orden> listaOrdenesServicio;

    public Mecanico(String nombre, String telefono, String salario,Taller ownedByTaller) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.salario = salario;
        this.ownedByTaller = ownedByTaller;
        this.listaOrdenesServicio = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Taller getOwnedByTaller() {
        return ownedByTaller;
    }

    public void setOwnedByTaller(Taller ownedByTaller) {
        this.ownedByTaller = ownedByTaller;
    }

    public ArrayList<Orden> getListaOrdenesServicio() {
        return listaOrdenesServicio;
    }

    public void setListaOrdenesServicio(ArrayList<Orden> listaOrdenesServicio) {
        this.listaOrdenesServicio = listaOrdenesServicio;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", salario='" + salario + '\'' +
                ", ownedByTaller=" + ownedByTaller +
                ", listaOrdenesServicio=" + listaOrdenesServicio +
                '}';
    }
}
