package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoTest.class.getName());
    // 4.
    @Test
    void BonificacionJuniorMayorQueCero() {
        LOG.info("Inicio test Assert True");
        EmpleadoVentas junior = new EmpleadoVentas("Cristian", "222", 25, 2_500_000, 4, 4, CategoriaEmpleado.JUNIOR, null, 5_000_000, 3);

        double bonificacion = junior.calcularBonificacionCategoria();
        assertTrue(bonificacion > 0, "La bonificación de un junior con salario mayor a 0 debe ser positiva");
        LOG.info("Fin test Assert True");

    }

    // 5.
    @Test
    void SalarioNetoNuncaNegativo() {
        LOG.info("Inicio test Assert True");
        EmpleadoPlanta planta = new EmpleadoPlanta("Royerg", "111", 30, 3_000_000, 4, 4, CategoriaEmpleado.SEMI_SENIOR, null, "tester", 10, 20_000, 100_000);
        EmpleadoVentas ventas = new EmpleadoVentas("Andres", "222", 25, 2_500_000, 4, 4, CategoriaEmpleado.JUNIOR, null, 5_000_000, 3);
        EmpleadoTemporal temporal = new EmpleadoTemporal("Juan", "333", 40, 0, 4, 4, CategoriaEmpleado.SENIOR, null, 120, 50_000);

        assertTrue(planta.calcularSalarioNeto() >= 0, "El salario neto de planta no debe ser negativo");
        assertTrue(ventas.calcularSalarioNeto() >= 0, "El salario neto de ventas no debe ser negativo");
        assertTrue(temporal.calcularSalarioNeto() >= 0, "El salario neto del temporal no debe ser negativo");
        LOG.info("Fin test Assert True");
    }

    // 7.
    @Test
    void ExcepcionSalarioBaseNegativo() {
        LOG.info("Inicio test Assert Throws");
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoVentas("Ana", "444", 28, -1000, 4, 4, CategoriaEmpleado.JUNIOR, null, 1_000_000, 5), "Debe lanzarse la excepcion con salario base negativo");
        LOG.info("Fin test Assert Throws");
    }

    // 13.
    @Test
    void SalarioNetoPlantaMayorQueSalarioBase() {
        LOG.info("Inicio test Assert True");
        EmpleadoPlanta planta = new EmpleadoPlanta("Carlos", "111", 30, 3_000_000, 4, 4, CategoriaEmpleado.SEMI_SENIOR, null, "Desarrollador", 10, 20_000, 100_000);
        assertTrue(planta.calcularSalarioNeto() > planta.getSalarioBase(), "El salario neto del empleado de planta debe superar su salario base");
        LOG.info("Inicio test Assert True");
    }

}