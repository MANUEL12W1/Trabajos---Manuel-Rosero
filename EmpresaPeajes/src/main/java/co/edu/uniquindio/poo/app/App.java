package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Camion;
import co.edu.uniquindio.poo.model.Carro;
import co.edu.uniquindio.poo.model.Conductor;
import co.edu.uniquindio.poo.model.EmpresaPeajes;
import co.edu.uniquindio.poo.model.Moto;
import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {
        EmpresaPeajes empresa = new EmpresaPeajes("Peajes del Quindio");
        Conductor conductor1 = new Conductor("Manuel", "Rosero", LocalDate.of(2007, 10, 15), "10564656");

        Carro miCarro = new Carro("XGZ-323", conductor1, true, true);

        Moto miMoto = new Moto("MOT-994", conductor1, 250);

        Camion camionPesado = new Camion("CAM-001", conductor1, 12.0, 3);

        Camion camionLiviano = new Camion("CAM-002", conductor1, 8.0, 2);

        empresa.agregarVehiculo(miCarro);
        empresa.agregarVehiculo(miMoto);
        empresa.agregarVehiculo(camionPesado);
        empresa.agregarVehiculo(camionLiviano);

        System.out.println("VALORES DE PEAJE CALCULADOS");
        System.out.println("Carro: $" + miCarro.calcularValor());
        System.out.println("Moto: $" + miMoto.calcularValor());
        System.out.println("Camion Pesado: $" + camionPesado.calcularValor());
        System.out.println("Camion Liviano: $" + camionLiviano.calcularValor());
        System.out.println("");

        for (int i = 0; i < 6; i++) {
            camionPesado.registrarPagoPeaje();
        }

        for (int i = 0; i < 10; i++) {
            camionLiviano.registrarPagoPeaje();
        }

        System.out.println("\n REPORTE: CAMIONES PESADOS Y FRECUENTES");
        List<Camion> reporteCamiones = empresa.obtenerCamionesPesadosYFrecuentes();

        if (reporteCamiones.isEmpty()) {
            System.out.println("No se encontraron camiones que cumplan las condiciones.");
        } else {
            for (Camion camionActual : reporteCamiones) {
                System.out.println("Placa: " + camionActual.getPlaca());
                System.out.println("Capacidad Carga: " + camionActual.getCapacidadCarga() + " toneladas");
                System.out.println("Peajes Pagados: " + camionActual.getNumeroPeajes());
            }
        }
    }
}