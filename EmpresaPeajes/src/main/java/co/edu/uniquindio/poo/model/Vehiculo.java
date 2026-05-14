package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    protected String placa;
    protected int numeroPeajes;
    protected Conductor propietario;
    protected List<RegistroPeaje> listaRegistroPeaje;

    public Vehiculo(String placa, Conductor propietario) {
        this.placa = placa;
        this.propietario = propietario;
        this.listaRegistroPeaje = new ArrayList<>();
        this.numeroPeajes = 0;
    }

    public abstract double calcularValor();

    public void registrarPagoPeaje() {
        this.numeroPeajes++;
    }

    public int getNumeroPeajes() {
        return numeroPeajes;
    }

    public String getPlaca() {
        return placa;
    }
}