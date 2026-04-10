package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Empleado;

import javax.swing.JOptionPane;
import java.time.LocalTime;
import java.util.ArrayList;

public class Aplicacion {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("Empresa", LocalTime.of(7, 0));

        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU\n" +
                            "1. Crear empleado\n" +
                            "2. Ver empleados que llegaron tarde\n" +
                            "3. Consultar Empleado\n" +
                            "4. Salir"
            ));

            switch (opcion) {

                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                    String cedula = JOptionPane.showInputDialog("Ingrese la cédula:");

                    int hEntrada = Integer.parseInt(JOptionPane.showInputDialog("Hora de entrada (0-23):"));
                    int mEntrada = Integer.parseInt(JOptionPane.showInputDialog("Minuto de entrada (0-59):"));

                    int hSalida = Integer.parseInt(JOptionPane.showInputDialog("Hora de salida (0-23):"));
                    int mSalida = Integer.parseInt(JOptionPane.showInputDialog("Minuto de salida (0-59):"));

                    // FIX: se eliminó la creación redundante de 'nuevo' que nunca se agregaba a la lista
                    String resultado = empresa.registrarEmpleado(
                            nombre, cedula,
                            LocalTime.of(hEntrada, mEntrada),
                            LocalTime.of(hSalida, mSalida),
                            empresa
                    );

                    JOptionPane.showMessageDialog(null, resultado);
                    break;

                case 2:
                    // FIX: consultarEmpleadosTarde() ya no necesita argumento
                    ArrayList<Empleado> tardones = empresa.consultarEmpleadosTarde();

                    if (tardones.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados que llegaron tarde");
                    } else {
                        String mensaje = "Empleados que llegaron tarde:\n";
                        for (Empleado e : tardones) {
                            mensaje += "• " + e.getNombre() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                    break;

                case 3:
                    String cedulaBuscar = JOptionPane.showInputDialog("Ingrese la cédula del empleado:");

                    Empleado encontrado = empresa.buscarEmpleado(cedulaBuscar);

                    if (encontrado != null) {
                        JOptionPane.showMessageDialog(null, "Empleado encontrado:\n" + encontrado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado");
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 4);
    }
}