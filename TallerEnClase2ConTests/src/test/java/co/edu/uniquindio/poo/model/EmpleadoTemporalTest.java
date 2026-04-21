package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTemporalTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoTemporalTest.class.getName());
    // 2.
    @Test
    void SalarioNetoTemporalNoEsCero() {
        LOG.info("Inicio test Assert Not Equals");
        EmpleadoTemporal temporal = new EmpleadoTemporal(
                "Robinson", "333", 80,
                0, 4, 4,
                CategoriaEmpleado.SENIOR,null ,
                120, 50_000
        );

        assertNotEquals(0, temporal.calcularSalarioNeto(), 0.01, "El salario neto del temporal no debe ser 0");
        LOG.info("Fin test Assert Not Equals");
    }
    // 14.
    @Test
    void SalarioNetoTemporalMayorQueCero() {
        LOG.info("Inicio test Assert True");
        EmpleadoTemporal temporal = new EmpleadoTemporal(
                "Pedro", "333", 40,
                0, 4, 4,
                CategoriaEmpleado.SENIOR, null,
                120, 50_000
        );

        assertTrue(temporal.calcularSalarioNeto() > 0, "El salario neto del temporal debe ser mayor a 0");
        LOG.info("Inicio test Assert True");
    }
}