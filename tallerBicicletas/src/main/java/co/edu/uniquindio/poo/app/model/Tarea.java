package co.edu.uniquindio.poo.app.model;

import java.util.ArrayList;

public class Tarea {
    // Atributos
    private int numeroTareas;
    private String tipoTarea;
    private double tiempoHoras;
    //Relaciones
    private ArrayList<Repuesto> listaRepuestos;

    //Constructor
    public Tarea(int numeroTareas, String tipoTarea, double tiempoHoras) {
        this.numeroTareas = numeroTareas;
        this.tipoTarea = tipoTarea;
        this.tiempoHoras = tiempoHoras;
        this.listaRepuestos = new ArrayList<>();
    }

    //Get y Set
    public int getNumeroTareas() {
        return numeroTareas;
    }

    public void setNumeroTareas(int numeroTareas) {
        this.numeroTareas = numeroTareas;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public double getTiempoHoras() {
        return tiempoHoras;
    }

    public void setTiempoHoras(double tiempoHoras) {
        this.tiempoHoras = tiempoHoras;
    }

    public ArrayList<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(ArrayList<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }
    //Metodos
    public void agregarRepuesto(Repuesto repuesto){
        listaRepuestos.add(repuesto);
    }
    public double calcularCostoRepuestos (){
        double total = 0;
        for (Repuesto repuesto : listaRepuestos){
            total+=repuesto.getCantidad() * repuesto.getCostoUnitario();
        }
        return total;
    }

    // toString

    @Override
    public String toString() {
        return "Tarea{" +
                "numeroTareas=" + numeroTareas +
                ", tipoTarea='" + tipoTarea + '\'' +
                ", tiempoHoras=" + tiempoHoras +
                ", listaRepuestos=" + listaRepuestos +
                '}';
    }
}
