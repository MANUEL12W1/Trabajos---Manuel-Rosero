package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpresaPeajesTest {

    @Test
    void testObtenerCamionesPesadosYFrecuentes() {
        EmpresaPeajes empresa = new EmpresaPeajes("Peajes del Quindio");
        Conductor conductor = new Conductor("Luis", "Diaz", LocalDate.of(1990, 1, 1), "12345");
        Camion camionCumple = new Camion("CAM-001", conductor, 12, 3);
        camionCumple.numeroPeajes = 6;

        Camion camionFallaPeso = new Camion("CAM-002", conductor, 8, 2);
        camionFallaPeso.numeroPeajes = 10;

        Moto motoFallaTipo = new Moto("MOT-123", conductor, 250);
        motoFallaTipo.numeroPeajes = 8;

        empresa.agregarVehiculo(camionCumple);
        empresa.agregarVehiculo(camionFallaPeso);
        empresa.agregarVehiculo(motoFallaTipo);

        List<Camion> resultado = empresa.obtenerCamionesPesadosYFrecuentes();

        assertEquals(1, resultado.size(), "Solo debería haber 1 camión que cumpla ambas condiciones.");
        assertEquals("CAM-001", resultado.get(0).getPlaca(), "El camión filtrado debe ser el CAM-001.");
    }
}