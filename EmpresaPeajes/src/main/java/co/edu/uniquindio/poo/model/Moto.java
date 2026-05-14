package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String placa, Conductor propietario, int cilindraje) {
        super(placa, propietario);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularValor() {
        double valorFinal = 5000.0;
        if (cilindraje > 200) {
            valorFinal += 2000.0; // Recargo
        }
        return valorFinal;
    }
}