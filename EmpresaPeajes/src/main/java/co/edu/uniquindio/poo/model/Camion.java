package co.edu.uniquindio.poo.model;

public class Camion extends Vehiculo {
    private double capacidadCarga; // Cambiado a double para representar toneladas (ej. 10.5)
    private int numeroEjes;

    public Camion(String placa, Conductor propietario, double capacidadCarga, int numeroEjes) {
        super(placa, propietario);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    @Override
    public double calcularValor() {
        double valorFinal = numeroEjes * 7000.0;
        if (capacidadCarga > 10.0) {
            valorFinal += (valorFinal * 0.10); // 10% de recargo sobre el total calculado
        }
        return valorFinal;
    }

    public double getCapacidadCarga() { return capacidadCarga; }
}