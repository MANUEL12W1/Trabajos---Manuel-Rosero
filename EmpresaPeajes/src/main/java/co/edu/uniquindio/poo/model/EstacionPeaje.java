package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class EstacionPeaje implements ICobrador {
    private String nombre;
    private String departamento;
    private double valorTotal;
    private List<RegistroPeaje> listaRegistroPeaje;

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.valorTotal = 0.0;
        this.listaRegistroPeaje = new ArrayList<>();
    }

    public double calcularValorPeaje() {
        return valorTotal;
    }

    @Override
    public void cobrarPeaje() {
        System.out.println("Estación de peaje automática cobrando...");
    }
}