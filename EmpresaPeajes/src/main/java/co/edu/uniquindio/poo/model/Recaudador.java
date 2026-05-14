package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recaudador extends Persona implements ICobrador {
    private double sueldoMensual;
    private List<RegistroPeaje> listaRegistroPeaje;

    public Recaudador(String nombres, String apellidos, LocalDate fechaNacimiento, String numeroDocumento, double sueldoMensual) {
        super(nombres, apellidos, fechaNacimiento, numeroDocumento);
        this.sueldoMensual = sueldoMensual;
        this.listaRegistroPeaje = new ArrayList<>();
    }

    @Override
    public void cobrarPeaje() {
        System.out.println("Recaudador cobrando peaje...");
    }
}


