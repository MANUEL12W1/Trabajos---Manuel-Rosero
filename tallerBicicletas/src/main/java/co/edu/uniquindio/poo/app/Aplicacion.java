package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Aplicacion {

    public static void main(String[] args) {

        Taller taller = new Taller("Mi Taller", "Calle 1 #2-3");
        int opcion = -1;
        while (opcion != 6) {
            String input = JOptionPane.showInputDialog(null,
                    "MENU PRINCIPAL\n\n" +
                            "1. Clientes\n" +
                            "2. Mecanicos\n" +
                            "3. Bicicletas\n" +
                            "4. Ordenes de Servicio\n" +
                            "5. Repuestos\n" +
                            "6. Salir\n\n" +
                            "Seleccione una opcion:");
            if (input == null) break;
            try {
                opcion = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
                continue;
            }
            switch (opcion) {
                case 1:
                    menuClientes(taller);
                    break;
                case 2:
                    menuMecanicos(taller);
                    break;
                case 3:
                    menuBicicletas(taller);
                    break;
                case 4:
                    menuOrdenes(taller);
                    break;
                case 5:
                    menuRepuestos(taller);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programma");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }
    }

    //CRUD CLIENTES
    private static void menuClientes(Taller taller) {
        String input = JOptionPane.showInputDialog(null,
                "MENU CLIENTES\n\n" +
                        "1. Registrar\n" +
                        "2. Buscar\n" +
                        "3. Actualizar\n" +
                        "4. Volver\n\n" +
                        "Seleccione una opcion:");
        if (input == null) return;
        switch (input.trim()) {
            case "1":
                String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
                if (nombre == null) return;
                String identificacion = JOptionPane.showInputDialog("Identificacion del cliente:");
                if (identificacion == null) return;
                String telefono = JOptionPane.showInputDialog("Telefono del cliente:");
                if (telefono == null) return;
                String numBicisStr = JOptionPane.showInputDialog("Numero de bicicletas del cliente:");
                if (numBicisStr == null) return;
                String direccion = JOptionPane.showInputDialog("Direccion del cliente:");
                if (direccion == null) return;
                String fechaStr = JOptionPane.showInputDialog("Fecha de nacimiento (YYYY-MM-DD):");
                if (fechaStr == null) return;

                try {
                    int numBicis = Integer.parseInt(numBicisStr.trim());
                    LocalDate fecha = LocalDate.parse(fechaStr.trim());
                    String resultado = taller.registrarCliente(nombre, identificacion, telefono, numBicis, direccion, fecha);
                    JOptionPane.showMessageDialog(null, resultado);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El numero de bicicletas debe ser un numero entero.");
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha invalido. Use YYYY-MM-DD.");
                }
                break;

            case "2":
                String identificacionBuscar = JOptionPane.showInputDialog("Identificacion del cliente:");
                if (identificacionBuscar == null) return;
                Cliente cliente = taller.buscarCliente(identificacionBuscar);
                if (cliente != null) {
                    JOptionPane.showMessageDialog(null, "Cliente encontrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                }
                break;

            case "3":
                String identificacionActualizar = JOptionPane.showInputDialog("Identificacion del cliente:");
                if (identificacionActualizar == null) return;
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                if (nuevoNombre == null) return;
                String nuevoTelefono = JOptionPane.showInputDialog("Nuevo telefono:");
                if (nuevoTelefono == null) return;
                String nuevoNumBicisStr = JOptionPane.showInputDialog("Nuevo numero de bicicletas:");
                if (nuevoNumBicisStr == null) return;
                String nuevaDireccion = JOptionPane.showInputDialog("Nueva direccion:");
                if (nuevaDireccion == null) return;
                String nuevaFechaStr = JOptionPane.showInputDialog("Nueva fecha de nacimiento (YYYY-MM-DD):");
                if (nuevaFechaStr == null) return;

                try {
                    int nuevoNumBicis = Integer.parseInt(nuevoNumBicisStr.trim());
                    LocalDate nuevaFecha = LocalDate.parse(nuevaFechaStr.trim());
                    String resultado = taller.actualizarCliente(nuevoNombre, identificacionActualizar, nuevoTelefono, nuevoNumBicis, nuevaDireccion, nuevaFecha);
                    JOptionPane.showMessageDialog(null, resultado);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El numero de bicicletas debe ser un numero entero");
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha invalido. Use YYYY-MM-DD");
                }
                break;

            case "4":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }
    }

    // CRUD MECANICOS
    private static void menuMecanicos(Taller taller) {
        String input = JOptionPane.showInputDialog(null,
                "MENU MECANICOS\n\n" +
                        "1. Registrar\n" +
                        "2. Buscar\n" +
                        "3. Actualizar\n" +
                        "4. Bicicletas arregladas por mecanico\n" +
                        "5. Volver\n\n" +
                        "Seleccione una opcion:");

        if (input == null) return;

        switch (input.trim()) {
            case "1":
                String nombre = JOptionPane.showInputDialog("Nombre del mecanico:");
                if (nombre == null) return;
                String telefono = JOptionPane.showInputDialog("Telefono del mecanico:");
                if (telefono == null) return;
                String salario = JOptionPane.showInputDialog("Salario del mecanico:");
                if (salario == null) return;

                String resultado = taller.registrarMecanico(nombre, telefono, salario);
                JOptionPane.showMessageDialog(null, resultado);
                break;

            case "2":
                String nombreBuscar = JOptionPane.showInputDialog("Nombre del mecanico:");
                if (nombreBuscar == null) return;
                Mecanico mecanico = taller.buscarMecanico(nombreBuscar);
                if (mecanico != null) {
                    JOptionPane.showMessageDialog(null, "Mecanico encontrado:\n" + mecanico.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Mecanico no encontrado.");
                }
                break;

            case "3":
                String nombreActualizar = JOptionPane.showInputDialog("Nombre del mecanico:");
                if (nombreActualizar == null) return;
                String nuevoTelefono = JOptionPane.showInputDialog("Nuevo telefono:");
                if (nuevoTelefono == null) return;
                String nuevoSalario = JOptionPane.showInputDialog("Nuevo salario:");
                if (nuevoSalario == null) return;

                String resultadoAct = taller.actualizarMecanico(nombreActualizar, nuevoTelefono, nuevoSalario);
                JOptionPane.showMessageDialog(null, resultadoAct);
                break;

            case "4":
                String nombreMecanico = JOptionPane.showInputDialog("Nombre del mecanico:");
                if (nombreMecanico == null) return;
                ArrayList<Bicicleta> bicicletas = taller.buscarBicicletasArregladasPorMecanico(nombreMecanico);
                if (bicicletas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontraron bicicletas arregladas por este mecanico.");
                } else {
                    StringBuilder sb = new StringBuilder("Bicicletas arregladas por " + nombreMecanico + ":\n\n");
                    for (Bicicleta b : bicicletas) {
                        sb.append("Marca: ").append(b.getMarca())
                                .append(" | Serial: ").append(b.getSerial())
                                .append(" | Color: ").append(b.getColor()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                break;

            case "5":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }
    }

    //CRUD BICICLETAS
    private static void menuBicicletas(Taller taller) {
        String input = JOptionPane.showInputDialog(null,
                "MENU BICICLETAS\n\n" +
                        "1. Registrar\n" +
                        "2. Buscar\n" +
                        "3. Actualizar\n" +
                        "4. Volver\n\n" +
                        "Seleccione una opcion:");
        if (input == null) return;
        switch (input.trim()) {
            case "1":
                String marca = JOptionPane.showInputDialog("Marca de la bicicleta:");
                if (marca == null) return;
                String serial = JOptionPane.showInputDialog("Serial de la bicicleta:");
                if (serial == null) return;
                String color = JOptionPane.showInputDialog("Color de la bicicleta:");
                if (color == null) return;

                String resultado = taller.registrarBicicleta(marca, serial, color);
                JOptionPane.showMessageDialog(null, resultado);
                break;

            case "2":
                String serialBuscar = JOptionPane.showInputDialog("Serial de la bicicleta:");
                if (serialBuscar == null) return;
                Bicicleta bicicleta = taller.buscarBicicleta(serialBuscar);
                if (bicicleta != null) {
                    JOptionPane.showMessageDialog(null, "Bicicleta encontrada:\n" + bicicleta.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Bicicleta no encontrada.");
                }
                break;

            case "3":
                String serialActualizar = JOptionPane.showInputDialog("Serial de la bicicleta:");
                if (serialActualizar == null) return;
                String nuevaMarca = JOptionPane.showInputDialog("Nueva marca:");
                if (nuevaMarca == null) return;
                String nuevoColor = JOptionPane.showInputDialog("Nuevo color:");
                if (nuevoColor == null) return;

                String resultadoAct = taller.actualizarBicicleta(nuevaMarca, serialActualizar, nuevoColor);
                JOptionPane.showMessageDialog(null, resultadoAct);
                break;

            case "4":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }
    }

    //CRUD ORDENES
    private static void menuOrdenes(Taller taller) {
        String input = JOptionPane.showInputDialog(null,
                "MENU ORDENES DE SERVICIO\n\n" +
                        "1. Registrar\n" +
                        "2. Buscar\n" +
                        "3. Actualizar\n" +
                        "4. Volver\n\n" +
                        "Seleccione una opcion:");

        if (input == null) return;

        switch (input.trim()) {
            case "1":
                String codigo = JOptionPane.showInputDialog("Codigo de la orden:");
                if (codigo == null) return;
                String descripcion = JOptionPane.showInputDialog("Descripcion de la orden:");
                if (descripcion == null) return;
                String fechaIngresoStr = JOptionPane.showInputDialog("Fecha de ingreso (YYYY-MM-DD):");
                if (fechaIngresoStr == null) return;
                String fechaSalidaStr = JOptionPane.showInputDialog("Fecha de salida (YYYY-MM-DD):");
                if (fechaSalidaStr == null) return;
                String costoStr = JOptionPane.showInputDialog("Costo de la orden:");
                if (costoStr == null) return;

                try {
                    LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr.trim());
                    LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr.trim());
                    double costo = Double.parseDouble(costoStr.trim());
                    String resultado = taller.registrarOrden(codigo, descripcion, fechaIngreso, fechaSalida, costo);
                    JOptionPane.showMessageDialog(null, resultado);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha invalido. Use YYYY-MM-DD.");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El costo debe ser un numero.");
                }
                break;

            case "2":
                String codigoBuscar = JOptionPane.showInputDialog("Codigo de la orden a buscar:");
                if (codigoBuscar == null) return;
                Orden orden = taller.buscarOrden(codigoBuscar);
                if (orden != null) {
                    JOptionPane.showMessageDialog(null, "Orden encontrada:\n" + orden.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Orden no encontrada.");
                }
                break;

            case "3":
                String codigoActualizar = JOptionPane.showInputDialog("Codigo de la orden:");
                if (codigoActualizar == null) return;
                String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripcion:");
                if (nuevaDescripcion == null) return;
                String nuevaFechaIngresoStr = JOptionPane.showInputDialog("Nueva fecha de ingreso (YYYY-MM-DD):");
                if (nuevaFechaIngresoStr == null) return;
                String nuevaFechaSalidaStr = JOptionPane.showInputDialog("Nueva fecha de salida (YYYY-MM-DD):");
                if (nuevaFechaSalidaStr == null) return;
                String nuevoCostoStr = JOptionPane.showInputDialog("Nuevo costo:");
                if (nuevoCostoStr == null) return;

                try {
                    LocalDate nuevaFechaIngreso = LocalDate.parse(nuevaFechaIngresoStr.trim());
                    LocalDate nuevaFechaSalida = LocalDate.parse(nuevaFechaSalidaStr.trim());
                    double nuevoCosto = Double.parseDouble(nuevoCostoStr.trim());
                    String resultadoAct = taller.actualizarOrden(codigoActualizar, nuevaDescripcion, nuevaFechaIngreso, nuevaFechaSalida, nuevoCosto);
                    JOptionPane.showMessageDialog(null, resultadoAct);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha invalido. Use YYYY-MM-DD.");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El costo debe ser un numero.");
                }
                break;

            case "4":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }
    }

    // CRUD REPUESTOS
    private static void menuRepuestos(Taller taller) {
        String input = JOptionPane.showInputDialog(null,
                "MENU REPUESTOS\n\n" +
                        "1. Registrar\n" +
                        "2. Buscar\n" +
                        "3. Actualizar\n" +
                        "4. Volver\n\n" +
                        "Seleccione una opcion:");

        if (input == null) return;

        switch (input.trim()) {
            case "1":
                String nombre = JOptionPane.showInputDialog("Nombre del repuesto:");
                if (nombre == null) return;
                String costoStr = JOptionPane.showInputDialog("Costo del repuesto:");
                if (costoStr == null) return;
                String cantidadStr = JOptionPane.showInputDialog("Cantidad del repuesto:");
                if (cantidadStr == null) return;

                try {
                    double costo = Double.parseDouble(costoStr.trim());
                    int cantidad = Integer.parseInt(cantidadStr.trim());
                    String resultado = taller.registrarRepuesto(nombre, costo, cantidad);
                    JOptionPane.showMessageDialog(null, resultado);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Costo y cantidad deben ser numeros.");
                }
                break;

            case "2":
                String nombreBuscar = JOptionPane.showInputDialog("Nombre del repuestto:");
                if (nombreBuscar == null) return;
                Repuesto repuesto = taller.buscarRepuesto(nombreBuscar);
                if (repuesto != null) {
                    JOptionPane.showMessageDialog(null, "Repuesto encontrado:\n" + repuesto.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Repuesto no encontrado.");
                }
                break;

            case "3":
                String nombreActualizar = JOptionPane.showInputDialog("Nombre del repuesto:");
                if (nombreActualizar == null) return;
                String nuevoCostoStr = JOptionPane.showInputDialog("Nuevo costo:");
                if (nuevoCostoStr == null) return;
                String nuevaCantidadStr = JOptionPane.showInputDialog("Nueva cantidad:");
                if (nuevaCantidadStr == null) return;

                try {
                    double nuevoCosto = Double.parseDouble(nuevoCostoStr.trim());
                    int nuevaCantidad = Integer.parseInt(nuevaCantidadStr.trim());
                    String resultadoAct = taller.actualizarRepuesto(nombreActualizar, nuevoCosto, nuevaCantidad);
                    JOptionPane.showMessageDialog(null, resultadoAct);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Costo y cantidad deben ser numeros.");
                }
                break;

            case "4":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }
    }
}
