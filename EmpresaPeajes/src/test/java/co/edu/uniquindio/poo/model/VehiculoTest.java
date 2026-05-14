package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehiculoTest {

    @Test
    void calcularValorCarro() {
        Conductor conductor = new Conductor("Juan", "Perez", LocalDate.of(1990, 1, 1), "12345");
        Carro miCarro = new Carro("XYZ-123", conductor, true, true);
        double valorCalculado = miCarro.calcularValor();
        assertEquals(9500.0, valorCalculado, "El cálculo del peaje para carro eléctrico y público es incorrecto.");
    }

    @Test
    void calcularValorMoto() {
        Conductor conductor = new Conductor("Maria", "Lopez", LocalDate.of(1995, 5, 10), "54321");
        Moto miMoto = new Moto("MTO-456", conductor, 250);
        double valorCalculado = miMoto.calcularValor();
        assertEquals(7000.0, valorCalculado, "El cálculo del peaje para moto con alto cilindraje es incorrecto.");
    }

    @Test
    void calcularValorCamion() {
        Conductor conductor = new Conductor("Carlos", "Gomez", LocalDate.of(1980, 8, 20), "98765");Camion miCamion = new Camion("CAM-789", conductor, 12.0, 3);
        double valorCalculado = miCamion.calcularValor();
        assertEquals(23100.0, valorCalculado, "El cálculo del peaje para camión pesado es incorrecto.");
    }
}