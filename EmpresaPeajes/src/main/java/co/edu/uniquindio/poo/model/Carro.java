package co.edu.uniquindio.poo.model;

public class Carro extends Vehiculo {
    private boolean electrico;
    private boolean publico;

    public Carro(String placa, Conductor propietario, boolean electrico, boolean publico) {
        super(placa, propietario);
        this.electrico = electrico;
        this.publico = publico;
    }

    @Override
    public double calcularValor() {
        double valorBase = 10000.0;
        double valorFinal = valorBase;

        if (electrico) valorFinal -= (valorBase * 0.20); // Descuento 20%
        if (publico) valorFinal += (valorBase * 0.15); // Incremento 15%

        return valorFinal;
    }
}