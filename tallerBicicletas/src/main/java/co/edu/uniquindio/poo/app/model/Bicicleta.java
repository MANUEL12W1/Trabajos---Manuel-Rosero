package co.edu.uniquindio.poo.app.model;

import java.util.Date;

public class Bicicleta {
    // Atributos
    private String modelo;
    private String color;
    private String dueño;
    private Date fechaIngreso;
    private Date fechaSalida;

    // Constructor
    public Bicicleta (String modelo, String color, String dueño, Date fechaIngreso, Date fechaSalida){
        this.modelo = modelo;
        this.color = color;
        this.dueño = dueño;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    // Get y Set

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }


    // Metodos

    // toString


    @Override
    public String toString() {
        return "Bicicleta{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", dueño='" + dueño + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
