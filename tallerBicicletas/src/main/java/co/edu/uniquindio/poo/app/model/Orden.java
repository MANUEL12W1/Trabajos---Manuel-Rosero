package co.edu.uniquindio.poo.app.model;

import java.util.Date;
import java.util.ArrayList;

public class Orden {
    //Atributos
    private String problema;
    private double costoTotal;
    private EstadoOrden estadoOrden;
    private Mecanico mecanico;
    private Date fechaIngreso;

    //Relaciomes
    private ArrayList<Tarea> listaTareas;

    // Constructor
    public Orden(String problema, double costoTotal, Date fechaIngreso) {
        this.problema = problema;
        this.fechaIngreso = fechaIngreso;
        this.costoTotal = costoTotal;
        this.estadoOrden = EstadoOrden.RECIBIDA;
        this.mecanico = null;
        this.listaTareas = new ArrayList<>();
    }
    //Get y Set

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    // Metodos
    public void asignarMecanico (Mecanico mecanico){
        this.mecanico = mecanico;
    }
    public void agregarTarea (Tarea tarea){
        this.listaTareas.add(tarea);
    }
    public double calcularCostoTotal (){
        double totalRepuestos = 0;
        double totalManoObra = 0;
        for ( Tarea tarea : listaTareas){
            totalRepuestos += tarea.calcularCostoRepuestos();
            if (mecanico != null){
                totalManoObra += tarea.getTiempoHoras() * mecanico.getTarifaPorHora();
            }
        }
        double total = totalRepuestos + totalManoObra;
        setCostoTotal(total);
        return total;
    }
    public boolean cambiarEstado(EstadoOrden nuevoEstado){

        if (estadoOrden == EstadoOrden.RECIBIDA
                && nuevoEstado == EstadoOrden.EN_PROCESO){

            estadoOrden = nuevoEstado;
            return true;
        }

        if (estadoOrden == EstadoOrden.EN_PROCESO
                && nuevoEstado == EstadoOrden.FINALIZADA){

            estadoOrden = nuevoEstado;
            return true;
        }

        if (estadoOrden == EstadoOrden.FINALIZADA
                && nuevoEstado == EstadoOrden.ENTREGADA){

            estadoOrden = nuevoEstado;
            return true;
        }

        return false;
    }
    // toString

    @Override
    public String toString() {
        return "Orden{" +
                "problema='" + problema + '\'' +
                ", costoTotal=" + costoTotal +
                ", estadoOrden='" + estadoOrden + '\'' +
                ", mecanico=" + mecanico +
                ", fechaIngreso=" + fechaIngreso +
                ", listaTareas=" + listaTareas +
                '}';
    }
}