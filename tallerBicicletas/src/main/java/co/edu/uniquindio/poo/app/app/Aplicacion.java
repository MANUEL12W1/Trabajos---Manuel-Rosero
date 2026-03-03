package co.edu.uniquindio.poo.app.app;

import co.edu.uniquindio.poo.app.model.*;

import java.util.Date;

public class Aplicacion {
    public static void main(String[] args) {

        // Codigo Principal (No LÓGICA)
        TallerBicicletas taller = new TallerBicicletas("Taller De Manuel", "Manuel", 1);

        Mecanico juan = new Mecanico("Juan", 1500);
        taller.agregarMecanico(juan);

        Cliente cliente = new Cliente("Camilo", "3185454373", "camilo1221@gmail.com", 2);
        taller.registrarCliente(cliente);

        Date fechaActual = new Date();
        Date fechaSalida = new Date(fechaActual.getTime() + (7L * 24 * 60 * 60 * 1000));

        Bicicleta bici = new Bicicleta("GW", "Rojo", "Camilo", fechaActual, fechaSalida);
        cliente.setBicicleta(bici);

        Orden orden = new Orden("La bicicleta no frena", 233.3, fechaActual);
        orden.asignarMecanico(juan);

        Tarea tarea1 = new Tarea(1, "Ajuste Frenos", 2.0);
        orden.agregarTarea(tarea1);

        taller.crearOrden(orden);

        double total = orden.calcularCostoTotal();

        System.out.println("RESUMEN DE ORDEN");
        System.out.println("Problema: " + orden.getProblema());
        System.out.println("Estado: " + orden.getEstadoOrden());
        System.out.println("Mecánico: " + orden.getMecanico().getNombre());
        System.out.println("Tarifa/hora: $" + orden.getMecanico().getTarifaPorHora());
        System.out.println("Fecha: " + orden.getFechaIngreso());
        System.out.println("Tareas: " + orden.getListaTareas().size() + " tarea(s)");
        System.out.println("-----------------------------");
        System.out.println("Costo Total  : $" + total);
        System.out.println("-----------------------------");
        System.out.println("DATOS DEL CLIENTE");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("-----------------------------");
        System.out.println("DATOS DE LA BICICLETA");
        System.out.println("Modelo: " + cliente.getBicicleta().getModelo());
        System.out.println("Color: " + cliente.getBicicleta().getColor());
        System.out.println("Dueño: " + cliente.getBicicleta().getDueño());
        System.out.println("Fecha Ingreso: " + cliente.getBicicleta().getFechaIngreso());
        System.out.println("Fecha Salida : " + cliente.getBicicleta().getFechaSalida());
    }
}
