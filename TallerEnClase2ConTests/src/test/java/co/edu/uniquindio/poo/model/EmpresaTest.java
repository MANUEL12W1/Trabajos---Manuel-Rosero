package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());
    //3
    @Test
    void EmpleadosAlmacenadosCorrectos() {
        LOG.info("Inicio test Assert Equals");
        Empresa empresa = new Empresa("Apple");
        EmpleadoPlanta planta = new EmpleadoPlanta("Manuel", "123", 18, 3_000_000, 4, 4, CategoriaEmpleado.SEMI_SENIOR, empresa, "jefe", 10, 20_000, 100_000);
        EmpleadoVentas ventas = new EmpleadoVentas("Santiago", "222", 20, 2_500_000, 4, 4, CategoriaEmpleado.JUNIOR, empresa, 5_000_000, 3);

        empresa.registrarEmpleado(planta);
        empresa.registrarEmpleado(ventas);

        ArrayList<Empleado> lista = empresa.getListaEmpleados();
        assertEquals(2, lista.size(), "Deben existir exactamente 2 empleados");
        assertTrue(lista.contains(planta), "La lista debe contener al empleado de planta");
        assertTrue(lista.contains(ventas), "La lista debe contener al empleado de ventas");
        LOG.info("Fin test Assert Equals");
    }

    // 6.
    @Test
    void BuscarEmpleadoInexistenteRetornaNull() {
        LOG.info("Inicio test Assert Null");
        Empresa empresa = new Empresa("Apple");
        EmpleadoPlanta planta = new EmpleadoPlanta("Juam", "111", 30, 3_000_000, 4, 4, CategoriaEmpleado.SEMI_SENIOR, empresa, "secretario", 10, 20_000, 100_000);
        empresa.registrarEmpleado(planta);

        Empleado resultado = empresa.buscarEmpleado("999");
        assertNull(resultado, "Buscar un documento inexistente debe retornar null");
        LOG.info("Fin test Assert Null");
    }

    // 8.
    @Test
    void EmpleadosConSalarioMayorA() {
        LOG.info("Inicio test Assert True");
        Empresa empresa = new Empresa("Apple");
        EmpleadoPlanta planta = new EmpleadoPlanta("Manuel", "111", 30, 3_000_000, 4, 4, CategoriaEmpleado.SEMI_SENIOR, empresa, "Desarrollador", 10, 20_000, 100_000);
        EmpleadoVentas ventas = new EmpleadoVentas("Santiago", "222", 25, 2_500_000, 4, 4, CategoriaEmpleado.JUNIOR, empresa, 5_000_000, 3);
        EmpleadoTemporal temporal = new EmpleadoTemporal("Pedro", "333", 40, 0, 4, 4, CategoriaEmpleado.SENIOR, empresa, 120, 50_000);

        empresa.registrarEmpleado(planta);
        empresa.registrarEmpleado(ventas);
        empresa.registrarEmpleado(temporal);

        double umbral = 2_000_000;
        ArrayList<Empleado> resultado = empresa.empleadosConSalarioMayorA(umbral);

        for (Empleado e : resultado) {
            assertTrue(e.calcularSalarioNeto() > umbral, e.getNombre() + " no debería estar en la lista");
        }
        for (Empleado e : empresa.getListaEmpleados()) {
            if (e.calcularSalarioNeto() > umbral) {
                assertTrue(resultado.contains(e),
                        e.getNombre() + " debería estar en la lista");
            }
        }
        int posAnterior = -1;
        for (Empleado e : resultado) {
            int posActual = empresa.getListaEmpleados().indexOf(e);
            assertTrue(posActual > posAnterior, "El orden de registro debe conservarse");
            posAnterior = posActual;
        }
        LOG.info("Fin test Assert True");
    }

    // 9.
    @Test
    void BuscarDocumentoInexistenteEnEmpresaVacia() {
        LOG.info("Inicio test Assert Null");
        Empresa empresa = new Empresa("Apple");
        Empleado resultado = empresa.buscarEmpleado("no existe el documento");
        assertNull(resultado, "En una empresa sin empleados, buscar cualquier documento debe retornar null");
        LOG.info("Fin test Assert Null");
    }

    // 10.
    @Test
    void NoDuplicadosMismoDocumento() {
        LOG.info("Inicio test Assert Equals");
        Empresa empresa = new Empresa("Apple");
        EmpleadoPlanta planta = new EmpleadoPlanta("Robinson", "111", 30, 3_000_000, 4, 4, CategoriaEmpleado.SEMI_SENIOR, empresa, "empleado", 10, 20_000, 100_000);

        empresa.registrarEmpleado(planta);
        String mensajeDuplicado = empresa.registrarEmpleado(planta);
        assertEquals(1, empresa.getListaEmpleados().size(), "Solo debe existir un empleado con ese documento");
        assertEquals("El empleado ya esta registrado", mensajeDuplicado, "El mensaje de duplicado no es el esperado");
        LOG.info("Inicio test Assert Equals");
    }

    // 11.
    @Test
    void EmpleadoConMayorSalarioNeto() {
        LOG.info("Inicio test Assert Not Null");
        Empresa empresa = new Empresa("Apple");
        EmpleadoPlanta planta = new EmpleadoPlanta("Cristian", "111", 30, 3_000_000, 4, 4, CategoriaEmpleado.SEMI_SENIOR, empresa, "empleado", 10, 20_000, 100_000);
        EmpleadoVentas ventas = new EmpleadoVentas("Laura Mesa", "222", 25, 2_500_000, 4, 4, CategoriaEmpleado.JUNIOR, empresa, 5_000_000, 3);
        EmpleadoTemporal temporal = new EmpleadoTemporal("Pedro Ríos", "333", 40, 0, 4, 4, CategoriaEmpleado.SENIOR, empresa, 120, 50_000);

        empresa.registrarEmpleado(planta);
        empresa.registrarEmpleado(ventas);
        empresa.registrarEmpleado(temporal);

        Empleado mayorSalario = empresa.obtenerMayorSalarioNeto();
        assertNotNull(mayorSalario, "Debe retornar un empleado, la lista no está vacía");

        for (Empleado e : empresa.getListaEmpleados()) {
            assertTrue(mayorSalario.calcularSalarioNeto() >= e.calcularSalarioNeto(),
                    "El empleado retornado no tiene el mayor salario neto");
        }
        LOG.info("Fin test Assert Not Null");
    }

    // 12.
    @Test
    void TemporalesConMasDe100Dias() {
        LOG.info("Inicio test Assert Equals");
        Empresa empresa = new Empresa("Apple");
        EmpleadoTemporal temporalLargo = new EmpleadoTemporal("Pedro", "333", 40, 0, 4, 4, CategoriaEmpleado.SENIOR, empresa, 120, 50_000);
        EmpleadoTemporal temporalCorto = new EmpleadoTemporal("Sofía", "555", 22, 0, 4, 4, CategoriaEmpleado.JUNIOR, empresa, 50, 40_000);

        empresa.registrarEmpleado(temporalLargo);
        empresa.registrarEmpleado(temporalCorto);

        ArrayList<EmpleadoTemporal> resultado = empresa.temporalesConMasDe(100);

        assertEquals(1, resultado.size(), "Solo un temporal debe tener más de 100 días trabajados");
        assertTrue(resultado.contains(temporalLargo), "El temporal con 120 días debe estar en la lista");
        assertFalse(resultado.contains(temporalCorto), "El temporal con 50 días NO debe estar en la lista");
        LOG.info("Inicio test Assert Equals");
    }

}