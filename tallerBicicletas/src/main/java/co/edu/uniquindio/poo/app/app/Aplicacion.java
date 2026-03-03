package co.edu.uniquindio.poo.app.app;

import co.edu.uniquindio.poo.app.model.*;

import javax.swing.JOptionPane;
import java.util.Date;

public class Aplicacion {
    public static void main(String[] args) {
        // Codigo Principal (No LÓGICA)
        TallerBicicletas taller = new TallerBicicletas("Taller De Manuel","Manuel",0);

        Mecanico juan = new Mecanico ("Juan", 1500);
        taller.agregarMecanico(juan);

        Cliente cliente = new Cliente ("Camilo","3185454373", "camilo1221@gmail.com", 2);
        taller.registrarCliente(cliente);

        Date fechaActual = new Date();

        Orden orden = new Orden ("La bicicleta no frena", 233.3,fechaActual );
        orden.asignarMecanico(juan);

        Tarea tarea1 = new Tarea (1, "Ajuste Frenos",2.0);
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



    }
}
