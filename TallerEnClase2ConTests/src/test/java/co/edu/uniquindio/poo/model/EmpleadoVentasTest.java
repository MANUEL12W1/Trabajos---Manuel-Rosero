package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoVentasTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoVentasTest.class.getName());
    // 1.
    @Test
    void SalarioBrutoEmpleadoVentas() {
        LOG.info("Inicio test Assert Equals");
        EmpleadoVentas ventas = new EmpleadoVentas("Laura", "222", 25, 2_500_000, 4, 4, CategoriaEmpleado.JUNIOR, null, 5_000_000, 3);

        double esperado = 2_500_000 + (2_500_000 * 0.05) + (5_000_000 * 0.03);
        assertEquals(esperado, ventas.calcularSalarioBruto(), 0.01, "El salario bruto del empleado de ventas no coincide");
        LOG.info("Fin test Assert Equals");
    }

}